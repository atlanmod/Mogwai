package fr.inria.atlanmod.mogwai.incquery.queries.util;

import fr.inria.atlanmod.mogwai.incquery.queries.ThrownExceptionsMatch;
import org.eclipse.gmt.modisco.java.TypeAccess;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the fr.inria.atlanmod.mogwai.incquery.queries.thrownExceptions pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ThrownExceptionsProcessor implements IMatchProcessor<ThrownExceptionsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pEx the value of pattern parameter Ex in the currently processed match
   * 
   */
  public abstract void process(final TypeAccess pEx);
  
  @Override
  public void process(final ThrownExceptionsMatch match) {
    process(match.getEx());
  }
}
