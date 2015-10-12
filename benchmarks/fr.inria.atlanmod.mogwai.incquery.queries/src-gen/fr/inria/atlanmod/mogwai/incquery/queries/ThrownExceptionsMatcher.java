package fr.inria.atlanmod.mogwai.incquery.queries;

import fr.inria.atlanmod.mogwai.incquery.queries.ThrownExceptionsMatch;
import fr.inria.atlanmod.mogwai.incquery.queries.util.ThrownExceptionsQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gmt.modisco.java.TypeAccess;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.tuple.Tuple;
import org.eclipse.incquery.runtime.util.IncQueryLoggingUtil;

/**
 * Generated pattern matcher API of the fr.inria.atlanmod.mogwai.incquery.queries.thrownExceptions pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ThrownExceptionsMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern thrownExceptions(Ex) {
 * 	Package(Pack); 
 * 	Package.ownedElements(Pack,Owned);
 * 	ClassDeclaration(Owned);
 * 	ClassDeclaration.bodyDeclarations(Owned,Body);
 * 	MethodDeclaration(Body);
 * 	MethodDeclaration.thrownExceptions(Body,Ex);
 * }
 * </pre></code>
 * 
 * @see ThrownExceptionsMatch
 * @see ThrownExceptionsProcessor
 * @see ThrownExceptionsQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ThrownExceptionsMatcher extends BaseMatcher<ThrownExceptionsMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ThrownExceptionsMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ThrownExceptionsMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ThrownExceptionsMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_EX = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ThrownExceptionsMatcher.class);
  
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
  public ThrownExceptionsMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ThrownExceptionsMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pEx the fixed value of pattern parameter Ex, or null if not bound.
   * @return matches represented as a ThrownExceptionsMatch object.
   * 
   */
  public Collection<ThrownExceptionsMatch> getAllMatches(final TypeAccess pEx) {
    return rawGetAllMatches(new Object[]{pEx});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pEx the fixed value of pattern parameter Ex, or null if not bound.
   * @return a match represented as a ThrownExceptionsMatch object, or null if no match is found.
   * 
   */
  public ThrownExceptionsMatch getOneArbitraryMatch(final TypeAccess pEx) {
    return rawGetOneArbitraryMatch(new Object[]{pEx});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pEx the fixed value of pattern parameter Ex, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final TypeAccess pEx) {
    return rawHasMatch(new Object[]{pEx});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pEx the fixed value of pattern parameter Ex, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final TypeAccess pEx) {
    return rawCountMatches(new Object[]{pEx});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pEx the fixed value of pattern parameter Ex, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final TypeAccess pEx, final IMatchProcessor<? super ThrownExceptionsMatch> processor) {
    rawForEachMatch(new Object[]{pEx}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pEx the fixed value of pattern parameter Ex, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final TypeAccess pEx, final IMatchProcessor<? super ThrownExceptionsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pEx}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pEx the fixed value of pattern parameter Ex, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ThrownExceptionsMatch newMatch(final TypeAccess pEx) {
    return ThrownExceptionsMatch.newMatch(pEx);
  }
  
  /**
   * Retrieve the set of values that occur in matches for Ex.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<TypeAccess> rawAccumulateAllValuesOfEx(final Object[] parameters) {
    Set<TypeAccess> results = new HashSet<TypeAccess>();
    rawAccumulateAllValues(POSITION_EX, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for Ex.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<TypeAccess> getAllValuesOfEx() {
    return rawAccumulateAllValuesOfEx(emptyArray());
  }
  
  @Override
  protected ThrownExceptionsMatch tupleToMatch(final Tuple t) {
    try {
    	return ThrownExceptionsMatch.newMatch((org.eclipse.gmt.modisco.java.TypeAccess) t.get(POSITION_EX));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ThrownExceptionsMatch arrayToMatch(final Object[] match) {
    try {
    	return ThrownExceptionsMatch.newMatch((org.eclipse.gmt.modisco.java.TypeAccess) match[POSITION_EX]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ThrownExceptionsMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ThrownExceptionsMatch.newMutableMatch((org.eclipse.gmt.modisco.java.TypeAccess) match[POSITION_EX]);
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
  public static IQuerySpecification<ThrownExceptionsMatcher> querySpecification() throws IncQueryException {
    return ThrownExceptionsQuerySpecification.instance();
  }
}
