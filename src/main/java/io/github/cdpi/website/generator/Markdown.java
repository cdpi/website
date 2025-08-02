package io.github.cdpi.website.generator;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Function;
import org.apache.commons.lang3.function.FailableBiConsumer;
import org.apache.commons.lang3.stream.Streams;
import io.github.cdpi.Argument;
import io.github.cdpi.annotations.WorkInProgress;
import io.github.cdpi.flexmark.Flexmark;

// Mettre ici tt les codes Markdown, on réorganise après...

@WorkInProgress
public final class Markdown
	{
	private final Function<String, String> renderer;

	public Markdown()
		{
		super();

		renderer = Flexmark.getHTMLRenderer();
		}

	public final String toHTML(final Path path) throws IOException
		{
		Argument.notNull(path);

		final var markdown = Files.readString(path, StandardCharsets.UTF_8);

		return renderer.apply(markdown);
		}

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
	}
