package fr.inria.atlanmod.mogwai.incquery.queries.util;

import fr.inria.atlanmod.mogwai.incquery.queries.Grabats09Match;
import org.eclipse.gmt.modisco.java.TypeDeclaration;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the fr.inria.atlanmod.mogwai.incquery.queries.grabats09 pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class Grabats09Processor implements IMatchProcessor<Grabats09Match> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTt the value of pattern parameter Tt in the currently processed match
   * 
   */
  public abstract void process(final TypeDeclaration pTt);
  
  @Override
  public void process(final Grabats09Match match) {
    process(match.getTt());
    
  }
}
