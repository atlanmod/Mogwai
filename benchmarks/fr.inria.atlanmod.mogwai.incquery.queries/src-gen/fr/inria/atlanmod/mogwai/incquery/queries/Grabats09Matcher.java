package fr.inria.atlanmod.mogwai.incquery.queries;

import fr.inria.atlanmod.mogwai.incquery.queries.Grabats09Match;
import fr.inria.atlanmod.mogwai.incquery.queries.util.Grabats09QuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gmt.modisco.java.TypeDeclaration;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.tuple.Tuple;
import org.eclipse.incquery.runtime.util.IncQueryLoggingUtil;

/**
 * Generated pattern matcher API of the fr.inria.atlanmod.mogwai.incquery.queries.grabats09 pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link Grabats09Match}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern grabats09(Tt) {
 * 	TypeDeclaration(Tt);
 * 	TypeDeclaration.bodyDeclarations(Tt,Bod);
 * 	MethodDeclaration(Bod);
 * 	MethodDeclaration.modifier.^static(Bod,true);
 * 	MethodDeclaration.returnType.type(Bod,Tt);
 * }
 * </pre></code>
 * 
 * @see Grabats09Match
 * @see Grabats09Processor
 * @see Grabats09QuerySpecification
 * 
 */
@SuppressWarnings("all")
public class Grabats09Matcher extends BaseMatcher<Grabats09Match> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static Grabats09Matcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    Grabats09Matcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new Grabats09Matcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_TT = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(Grabats09Matcher.class);
  
  /**
   * Initializes the pattern matcher over a given EMF model root (recommended: Resource or ResourceSet).
   * If a pattern matcher is already constructed with the same root, only a light-weight reference is returned.
   * The scope of pattern matching will be the given EMF model root and below (see FAQ for more precise definition).
   * The match set will be incrementally refreshed upon updates from this scope.
   * <p>The matcher will be created within the managed {@link IncQueryEngine} belonging to the EMF model root, so
   * multiple matchers will reuse the same engine and benefit from increased performance and reduced memory footprint.
   * @param emfRoot the root of the EMF containment hierarchy where the pattern matcher will operate. Recommended: Resource or ResourceSet.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead, e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}
   * 
   */
  @Deprecated
  public Grabats09Matcher(final Notifier emfRoot) throws IncQueryException {
    this(IncQueryEngine.on(emfRoot));
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead
   * 
   */
  @Deprecated
  public Grabats09Matcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pTt the fixed value of pattern parameter Tt, or null if not bound.
   * @return matches represented as a Grabats09Match object.
   * 
   */
  public Collection<Grabats09Match> getAllMatches(final TypeDeclaration pTt) {
    return rawGetAllMatches(new Object[]{pTt});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pTt the fixed value of pattern parameter Tt, or null if not bound.
   * @return a match represented as a Grabats09Match object, or null if no match is found.
   * 
   */
  public Grabats09Match getOneArbitraryMatch(final TypeDeclaration pTt) {
    return rawGetOneArbitraryMatch(new Object[]{pTt});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pTt the fixed value of pattern parameter Tt, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final TypeDeclaration pTt) {
    return rawHasMatch(new Object[]{pTt});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pTt the fixed value of pattern parameter Tt, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final TypeDeclaration pTt) {
    return rawCountMatches(new Object[]{pTt});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pTt the fixed value of pattern parameter Tt, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final TypeDeclaration pTt, final IMatchProcessor<? super Grabats09Match> processor) {
    rawForEachMatch(new Object[]{pTt}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pTt the fixed value of pattern parameter Tt, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final TypeDeclaration pTt, final IMatchProcessor<? super Grabats09Match> processor) {
    return rawForOneArbitraryMatch(new Object[]{pTt}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pTt the fixed value of pattern parameter Tt, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public Grabats09Match newMatch(final TypeDeclaration pTt) {
    return Grabats09Match.newMatch(pTt);
  }
  
  /**
   * Retrieve the set of values that occur in matches for Tt.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<TypeDeclaration> rawAccumulateAllValuesOfTt(final Object[] parameters) {
    Set<TypeDeclaration> results = new HashSet<TypeDeclaration>();
    rawAccumulateAllValues(POSITION_TT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for Tt.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<TypeDeclaration> getAllValuesOfTt() {
    return rawAccumulateAllValuesOfTt(emptyArray());
  }
  
  @Override
  protected Grabats09Match tupleToMatch(final Tuple t) {
    try {
    	return Grabats09Match.newMatch((org.eclipse.gmt.modisco.java.TypeDeclaration) t.get(POSITION_TT));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected Grabats09Match arrayToMatch(final Object[] match) {
    try {
    	return Grabats09Match.newMatch((org.eclipse.gmt.modisco.java.TypeDeclaration) match[POSITION_TT]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected Grabats09Match arrayToMatchMutable(final Object[] match) {
    try {
    	return Grabats09Match.newMutableMatch((org.eclipse.gmt.modisco.java.TypeDeclaration) match[POSITION_TT]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<Grabats09Matcher> querySpecification() throws IncQueryException {
    return Grabats09QuerySpecification.instance();
  }
}
