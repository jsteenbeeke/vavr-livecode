package nl.topicus.topiconf.vavr;

import io.vavr.collection.Traversable;
import io.vavr.control.Option;
import io.vavr.control.Try;
import org.hamcrest.Description;
import org.hamcrest.SelfDescribing;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import java.util.List;
import java.util.stream.Collectors;

public class VavrMatchers
{
	public static <T> TypeSafeDiagnosingMatcher<Traversable<T>> contains(
			T value)
	{
		return new TypeSafeDiagnosingMatcher<>()
		{
			@Override
			protected boolean matchesSafely(Traversable<T> item, Description mismatchDescription)
			{
				if (!item.contains(value))
				{
					mismatchDescription.appendList("[", ", ", "]", describeList(item.toJavaList()))
							.appendText(" contains ").appendDescriptionOf(describe(value));
					return false;
				}

				return true;
			}

			@Override
			public void describeTo(Description description)
			{
				description.appendText("contains ");
				description.appendDescriptionOf(describe(value));
			}
		};
	}

	public static TypeSafeDiagnosingMatcher<Option<?>> isNone() {
		return new TypeSafeDiagnosingMatcher<>() {
			@Override
			protected boolean matchesSafely(Option<?> item, Description mismatchDescription) {
				if (item.isDefined()) {

					mismatchDescription.appendText("is an option containing ").appendValue(item.get());

					return false;
				}

				return true;
			}

			@Override
			public void describeTo(Description description) {
				description.appendText("is an empty option");
			}
		};
	}

	public static TypeSafeDiagnosingMatcher<Try<?>> isSuccess() {
		return new TypeSafeDiagnosingMatcher<>() {
			@Override
			protected boolean matchesSafely(Try<?> item, Description mismatchDescription) {
				if (item.isFailure()) {

					mismatchDescription.appendText("is a failed try");

					return false;
				}

				return true;
			}

			@Override
			public void describeTo(Description description) {
				description.appendText("is a successful try");
			}
		};
	}

	public static <T> TypeSafeDiagnosingMatcher<Option<T>> isSome(T input) {
		return new TypeSafeDiagnosingMatcher<>() {
			@Override
			protected boolean matchesSafely(Option<T> item, Description mismatchDescription) {
				if (item.isEmpty()) {

					mismatchDescription.appendText("is an empty option");

					return false;
				} else if (!input.equals(item.get())) {

					mismatchDescription.appendText("is an option containing ").appendValue(item.get());
					return false;
				}

				return true;
			}

			@Override
			public void describeTo(Description description) {
				description.appendText("is an option containing ").appendValue(input);
			}
		};
	}

	public static <T extends SelfDescribing> TypeSafeDiagnosingMatcher<Traversable<T>> containsAll(
			Traversable<T> value)
	{
		return new TypeSafeDiagnosingMatcher<>()
		{
			@Override
			protected boolean matchesSafely(Traversable<T> item, Description mismatchDescription)
			{
				if (!item.containsAll(value))
				{
					mismatchDescription.appendList("[", ", ", "]", item.toJavaList())

							.appendText(" does not contain all of ");
					mismatchDescription.appendList("[", ", ", "]", value.toJavaList());
					return false;
				}

				return true;
			}

			@Override
			public void describeTo(Description description)
			{
				description.appendText(" contains all of ").appendList("[", ", ", "]", value.toJavaList());
			}
		};
	}

	private static <T> List<SelfDescribing> describeList(List<T> input) {
		return input.stream().map(VavrMatchers::describe).collect(Collectors.toList());
	}

	private static SelfDescribing describe(Object input) {
		if (input instanceof SelfDescribing) {
			return (SelfDescribing) input;
		}

		return description -> description.appendText(input.toString());
	}
}
