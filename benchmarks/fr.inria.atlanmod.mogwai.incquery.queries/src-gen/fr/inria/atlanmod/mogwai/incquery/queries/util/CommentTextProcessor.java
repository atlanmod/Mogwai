package fr.inria.atlanmod.mogwai.incquery.queries.util;

import fr.inria.atlanmod.mogwai.incquery.queries.CommentTextMatch;
import org.eclipse.gmt.modisco.java.TextElement;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the fr.inria.atlanmod.mogwai.incquery.queries.commentText pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class CommentTextProcessor implements IMatchProcessor<CommentTextMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pFf the value of pattern parameter Ff in the currently processed match
   * 
   */
  public abstract void process(final TextElement pFf);
  
  @Override
  public void process(final CommentTextMatch match) {
    process(match.getFf());
    
  }
}
