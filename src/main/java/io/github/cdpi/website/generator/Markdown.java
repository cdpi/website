package io.github.cdpi.website.generator;

import java.io.UncheckedIOException;
import java.nio.file.Path;
import java.util.function.Function;
import io.github.cdpi.exceptions.NullArgumentException;
import io.github.cdpi.flexmark.Flexmark;
import io.github.cdpi.io.IO;

/**
 * <h1>Markdown</h1>
 * 
 * @version 0.3.4
 * @since 0.3.4
 */
public final class Markdown extends Flexmark implements Function<String, String>
	{
	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.3.4
	 */
	@Override
	public String apply(final String markdown)
		{
		return render(parse(markdown));
		}

	/**
	 * @throws NullArgumentException
	 * @throws UncheckedIOException
	 * 
	 * @since 0.3.4
	 */
	public String render(final Path path)
		{
		return IO.READ.andThen(this::apply).apply(path);
		}

	// read .md
	//new ReadTextFile();

	// md2html
	//new MarkdownToHTML();

	// webpage template
	//new RenderTemplateOperation();
	//new RenderTemplateOperation(tpl);

	// write .html
	//new WriteTextFile();

	/*
	public final void toHTML(final List<Path> paths, final FailableBiConsumer<Path, String, IOException> consumer) throws IOException
		{
		Argument.notNull(paths);
		Argument.notNull(consumer);

		//final var directory = Paths.get("../../Mot & Machine/");
		//final var articles = List.of("1.md", "2.md", "3.md");

		final var stream = new Streams.FailableStream<Path>(paths.stream());

		stream.forEach(path ->
			{
			//final var markdown = directory.resolve(path);
			//final var html = directory.resolve(path + ".html");
			//blog.markdownToHTML(markdown, html, "article.ftl");

			final var html = toHTML(path);

			consumer.accept(path, html);
			});
		}
	*/
	}
