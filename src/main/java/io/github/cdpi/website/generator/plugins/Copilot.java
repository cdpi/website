package io.github.cdpi.website.generator.plugins;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

import io.github.cdpi.Argument;
import io.github.cdpi.copilot.api.Conversation;
import io.github.cdpi.exceptions.NullArgumentException;
import io.github.cdpi.util.Util;

/**
 * <h1>Copilot</h1>
 * 
 * @version 0.3.4
 * @since 0.1.0
 */
public final class Copilot extends Plugin
	{
	private static final io.github.cdpi.copilot.api.Copilot COPILOT = new io.github.cdpi.copilot.api.Copilot();

	/**
	 * @since 0.1.0
	 */
	public Copilot()
		{
		super();
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.1.0
	 */
	public Conversation getConversation(final String id) throws IOException
		{
		return COPILOT.getConversation(id);
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.2.2
	 */
	public BufferedImage getConversationPreview(final String id) throws IOException
		{
		return COPILOT.getConversationPreview(id);
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.3.4
	 */
	private final List<String> getConversationIDs(final Path path) throws IOException
		{
		Argument.notNull(path);

		final var notBlankAndNotComment = Util.NOT_BLANK.and(Predicate.not(Util.START_WITH_HASH));

		return Files.readAllLines(path).stream().filter(notBlankAndNotComment).toList();
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.3.4
	 */
	@SuppressWarnings("unused")
	private final List<String> getConversationIDs(final String path) throws IOException
		{
		return getConversationIDs(Paths.get(Argument.notNull(path)));
		}

	/*
	private static void getAllConversations(final List<String> ids, final FailableBiConsumer<String, Conversation, IOException> consumer) throws IOException
		{
		final var copilot = new Copilot();

		for (final var id : ids)
			{
			final var conversation = copilot.getConversation(id);

			consumer.accept(id, conversation);
			}
		}

	public static void getAllConversations(final String path) throws IOException
		{
		getAllConversations(getConversationIDs(path), (id, conversation) ->
			{
			System.out.println(id + " : " + conversation.getTitle());
			});
		}
	*/
	}
