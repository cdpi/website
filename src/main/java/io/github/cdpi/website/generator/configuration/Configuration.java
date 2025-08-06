package io.github.cdpi.website.generator.configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import com.google.gson.Gson;
import io.github.cdpi.Argument;
import io.github.cdpi.exceptions.NullArgumentException;

/**
 * <h1>Configuration</h1>
 * 
 * @version 0.3.5
 * @since 0.3.5
 */
public final class Configuration //extends StringTemplate // GSON Failed making field 'java.util.regex.Pattern#pattern' accessible
	{
	private String name;
	private String url;
	private List<Source> sources;
	private String destination;

	/**
	 * @since 0.3.5
	 */
	private Configuration()
		{
		super();
		}

	/**
	 * @since 0.3.5
	 */
	public String getName()
		{
		return name;
		}

	/**
	 * @since 0.3.5
	 */
	public String getURL()
		{
		return url;
		}

	/**
	 * @since 0.3.5
	 */
	public List<Source> getSources()
		{
		return Collections.unmodifiableList(sources);
		}

	/**
	 * @since 0.3.5
	 */
	public Path getDestination()
		{
		return Path.of(destination);
		}

	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.3.5
	 */
	public static Configuration parse(final String json)
		{
		Argument.notNull(json);

		final var gson = new Gson();

		return gson.fromJson(json, Configuration.class);
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.3.5
	 */
	public static Configuration parse(final Path path) throws IOException
		{
		Argument.notNull(path);

		return parse(Files.readString(path));
		}
	}
