package io.github.cdpi.website.generator.plugins;

import java.io.IOException;
import org.apache.commons.lang3.NotImplementedException;
import io.github.cdpi.annotations.WorkInProgress;
import io.github.cdpi.git.Git;

@WorkInProgress
public final class GitHubPages extends Git //implements IWebSitePublisher
	{
	public GitHubPages(final String workingDirectory)
		{
		super(workingDirectory);

		throw new NotImplementedException();
		}

	//@Override
	public void run() throws IOException
		{
		//add();
		//commit("sdsdsd");
		//push();

		throw new NotImplementedException();
		}
	}
