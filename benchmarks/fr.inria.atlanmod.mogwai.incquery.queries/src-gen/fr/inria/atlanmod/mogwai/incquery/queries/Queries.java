package fr.inria.atlanmod.mogwai.incquery.queries;

import fr.inria.atlanmod.mogwai.incquery.queries.CommentTextMatcher;
import fr.inria.atlanmod.mogwai.incquery.queries.Grabats09Matcher;
import fr.inria.atlanmod.mogwai.incquery.queries.InvisibleMethodsMatcher;
import fr.inria.atlanmod.mogwai.incquery.queries.ThrownExceptionsMatcher;
import fr.inria.atlanmod.mogwai.incquery.queries.util.CommentTextQuerySpecification;
import fr.inria.atlanmod.mogwai.incquery.queries.util.Grabats09QuerySpecification;
import fr.inria.atlanmod.mogwai.incquery.queries.util.InvisibleMethodsQuerySpecification;
import fr.inria.atlanmod.mogwai.incquery.queries.util.ThrownExceptionsQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * A pattern group formed of all patterns defined in queries.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare
 * an EMF-IncQuery engine for matching all patterns originally defined in file queries.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package fr.inria.atlanmod.mogwai.incquery.queries, the group contains the definition of the following patterns: <ul>
 * <li>invisibleMethods</li>
 * <li>thrownExceptions</li>
 * <li>grabats09</li>
 * <li>commentText</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class Queries extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Queries instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new Queries();
    }
    return INSTANCE;
    
  }
  
  private static Queries INSTANCE;
  
  private Queries() throws IncQueryException {
    querySpecifications.add(InvisibleMethodsQuerySpecification.instance());
    querySpecifications.add(ThrownExceptionsQuerySpecification.instance());
    querySpecifications.add(Grabats09QuerySpecification.instance());
    querySpecifications.add(CommentTextQuerySpecification.instance());
    
  }
  
  public InvisibleMethodsQuerySpecification getInvisibleMethods() throws IncQueryException {
    return InvisibleMethodsQuerySpecification.instance();
  }
  
  public InvisibleMethodsMatcher getInvisibleMethods(final IncQueryEngine engine) throws IncQueryException {
    return InvisibleMethodsMatcher.on(engine);
  }
  
  public ThrownExceptionsQuerySpecification getThrownExceptions() throws IncQueryException {
    return ThrownExceptionsQuerySpecification.instance();
  }
  
  public ThrownExceptionsMatcher getThrownExceptions(final IncQueryEngine engine) throws IncQueryException {
    return ThrownExceptionsMatcher.on(engine);
  }
  
  public Grabats09QuerySpecification getGrabats09() throws IncQueryException {
    return Grabats09QuerySpecification.instance();
  }
  
  public Grabats09Matcher getGrabats09(final IncQueryEngine engine) throws IncQueryException {
    return Grabats09Matcher.on(engine);
  }
  
  public CommentTextQuerySpecification getCommentText() throws IncQueryException {
    return CommentTextQuerySpecification.instance();
  }
  
  public CommentTextMatcher getCommentText(final IncQueryEngine engine) throws IncQueryException {
    return CommentTextMatcher.on(engine);
  }
}
