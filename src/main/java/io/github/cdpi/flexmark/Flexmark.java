package io.github.cdpi.flexmark;

import java.util.function.Function;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.Node;
import io.github.cdpi.Argument;
import io.github.cdpi.exceptions.NullArgumentException;

/**
 * <h1>Flexmark</h1>
 * 
 * @version 0.3.4
 * @since 0.3.0
 */
public class Flexmark extends Factory
	{
	protected final Parser parser;
	protected final HtmlRenderer renderer;

	/**
	 * @since 0.3.0
	 */
	public Flexmark()
		{
		super();

		parser = getParser();
		renderer = getRenderer();
		}

	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.3.4
	 */
	public final Document parse(final String markdown)
		{
		return parser.parse(Argument.notNull(markdown));
		}

	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.3.4
	 */
	public final String render(final Node node)
		{
		return renderer.render(Argument.notNull(node));
		}

	@Deprecated
	public static Function<String, String> getHTMLRenderer()
		{
		throw new UnsupportedOperationException();
		//return markdown -> renderer.render(parser.parse(markdown));
		}
	}
