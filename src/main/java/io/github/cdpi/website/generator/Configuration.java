package io.github.cdpi.website.generator;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import io.github.cdpi.Argument;
import io.github.cdpi.exceptions.NullArgumentException;
import io.github.cdpi.json.JSON;
import io.github.cdpi.util.StringTemplate;

/**
 * <h1>Configuration</h1>
 * 
 * @version 0.3.4
 * @since 0.3.4
 */
public class Configuration
	{
	protected final StringTemplate stringTemplate = new StringTemplate();

	/**
	 * @since 0.3.4
	 */
	public Configuration()
		{
		super();

		//stringTemplate.addValue(".", () -> "");
		//stringTemplate.addValue("..", () -> "");
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.3.4
	 */
	@SuppressWarnings("unused")
	public final Map<String, ?> getConfiguration(final Path path) throws IOException
		{
		final var map =  JSON.readAsMap(path);

		// TODO: Remplacer les variables {sdsd}
		map.forEach((key, value) ->
			{
			if (value instanceof String stringValue)
				{
				//map.put(key, (Object) stringTemplate.render(stringValue));
				}
			});

		return map;
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.3.4
	 */
	public final Map<String, ?> getConfiguration(final String path) throws IOException
		{
		return getConfiguration(Paths.get(Argument.notNull(path)));
		}
	}
