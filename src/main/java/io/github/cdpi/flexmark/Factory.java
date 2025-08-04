package io.github.cdpi.flexmark;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;

/**
 * <h1>Factory</h1>
 * 
 * @version 0.3.4
 * @since 0.3.4
 */
public class Factory
	{
	//final var options = new MutableDataSet();
	//final var parser = Parser.builder(options).build();
	//final var renderer = HtmlRenderer.builder(options).build();

	/**
	 * @since 0.3.4
	 */
	public static final Parser getParser()
		{
		return Parser.builder().build();
		}

	/**
	 * @since 0.3.4
	 */
	public static final HtmlRenderer getRenderer()
		{
		return HtmlRenderer.builder().build();
		}
	}
