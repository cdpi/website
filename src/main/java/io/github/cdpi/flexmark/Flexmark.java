package io.github.cdpi.flexmark;

import java.util.function.Function;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataSet;

/**
 * <h1>Flexmark</h1>
 * 
 * @version 0.3.0
 * @since 0.3.0
 */
public final class Flexmark
	{
	/**
	 * @since 0.3.0
	 */
	private Flexmark()
		{
		throw new UnsupportedOperationException();
		}

	/**
	 * @since 0.3.0
	 */
	public static Function<String, String> getHTMLRenderer()
		{
		final var options = new MutableDataSet();

		final var parser = Parser.builder(options).build();
		final var renderer = HtmlRenderer.builder(options).build();

		/*
		return new Function<String,String>()
			{
			@Override
			public final String apply(final String markdown)
				{
				return renderer.render(parser.parse(markdown));
				}
			};
		*/

		return markdown -> renderer.render(parser.parse(markdown));
		}
	}
