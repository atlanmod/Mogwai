package fr.inria.atlanmod.mogwai.incquery.queries.util;

import fr.inria.atlanmod.mogwai.incquery.queries.InvisibleMethodsMatch;
import org.eclipse.gmt.modisco.java.MethodDeclaration;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the fr.inria.atlanmod.mogwai.incquery.queries.invisibleMethods pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class InvisibleMethodsProcessor implements IMatchProcessor<InvisibleMethodsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pMet the value of pattern parameter Met in the currently processed match
   * 
   */
  public abstract void process(final MethodDeclaration pMet);
  
  @Override
  public void process(final InvisibleMethodsMatch match) {
    process(match.getMet());
    
  }
}
