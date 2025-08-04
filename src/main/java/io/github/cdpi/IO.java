package io.github.cdpi;

import java.nio.file.Path;
import java.util.function.Predicate;

// TODO: Dans Core

public class IO
	{
	public static final Predicate<Path> is(final String extension)
		{
		Argument.notNull(extension);

		return path -> Argument.notNull(path).getFileName().toString().endsWith(extension);
		}

	public static final Predicate<Path> isMarkdown()
		{
		return is(".md");
		}
	}
