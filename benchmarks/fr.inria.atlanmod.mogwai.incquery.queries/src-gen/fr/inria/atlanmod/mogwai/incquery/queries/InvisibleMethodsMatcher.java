package fr.inria.atlanmod.mogwai.incquery.queries;

import fr.inria.atlanmod.mogwai.incquery.queries.InvisibleMethodsMatch;
import fr.inria.atlanmod.mogwai.incquery.queries.util.InvisibleMethodsQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gmt.modisco.java.MethodDeclaration;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.tuple.Tuple;
import org.eclipse.incquery.runtime.rete.misc.DeltaMonitor;
import org.eclipse.incquery.runtime.util.IncQueryLoggingUtil;

/**
 * Generated pattern matcher API of the fr.inria.atlanmod.mogwai.incquery.queries.invisibleMethods pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link InvisibleMethodsMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern invisibleMethods(Met) {
 * 	ClassDeclaration.bodyDeclarations(_Cl, Met);
 * 	MethodDeclaration(Met);
 * 	MethodDeclaration.modifier.visibility(Met,VisibilityKind::^private);
 * } or
 * {
 * 	ClassDeclaration.bodyDeclarations(_Cl, Met);
 * 	MethodDeclaration(Met);
 * 	MethodDeclaration.modifier.visibility(Met,VisibilityKind::protected);
 * }
 * </pre></code>
 * 
 * @see InvisibleMethodsMatch
 * @see InvisibleMethodsProcessor
 * @see InvisibleMethodsQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class InvisibleMethodsMatcher extends BaseMatcher<InvisibleMethodsMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<InvisibleMethodsMatcher> querySpecification() throws IncQueryException {
    return InvisibleMethodsQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static InvisibleMethodsMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    InvisibleMethodsMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new InvisibleMethodsMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_MET = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(InvisibleMethodsMatcher.class);
  
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
  public InvisibleMethodsMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public InvisibleMethodsMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pMet the fixed value of pattern parameter Met, or null if not bound.
   * @return matches represented as a InvisibleMethodsMatch object.
   * 
   */
  public Collection<InvisibleMethodsMatch> getAllMatches(final MethodDeclaration pMet) {
    return rawGetAllMatches(new Object[]{pMet});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pMet the fixed value of pattern parameter Met, or null if not bound.
   * @return a match represented as a InvisibleMethodsMatch object, or null if no match is found.
   * 
   */
  public InvisibleMethodsMatch getOneArbitraryMatch(final MethodDeclaration pMet) {
    return rawGetOneArbitraryMatch(new Object[]{pMet});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pMet the fixed value of pattern parameter Met, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final MethodDeclaration pMet) {
    return rawHasMatch(new Object[]{pMet});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pMet the fixed value of pattern parameter Met, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final MethodDeclaration pMet) {
    return rawCountMatches(new Object[]{pMet});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pMet the fixed value of pattern parameter Met, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final MethodDeclaration pMet, final IMatchProcessor<? super InvisibleMethodsMatch> processor) {
    rawForEachMatch(new Object[]{pMet}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pMet the fixed value of pattern parameter Met, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final MethodDeclaration pMet, final IMatchProcessor<? super InvisibleMethodsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pMet}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pMet the fixed value of pattern parameter Met, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<InvisibleMethodsMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final MethodDeclaration pMet) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pMet});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pMet the fixed value of pattern parameter Met, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public InvisibleMethodsMatch newMatch(final MethodDeclaration pMet) {
    return InvisibleMethodsMatch.newMatch(pMet);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for Met.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<MethodDeclaration> rawAccumulateAllValuesOfMet(final Object[] parameters) {
    Set<MethodDeclaration> results = new HashSet<MethodDeclaration>();
    rawAccumulateAllValues(POSITION_MET, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for Met.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<MethodDeclaration> getAllValuesOfMet() {
    return rawAccumulateAllValuesOfMet(emptyArray());
  }
  
  @Override
  protected InvisibleMethodsMatch tupleToMatch(final Tuple t) {
    try {
      return InvisibleMethodsMatch.newMatch((org.eclipse.gmt.modisco.java.MethodDeclaration) t.get(POSITION_MET));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected InvisibleMethodsMatch arrayToMatch(final Object[] match) {
    try {
      return InvisibleMethodsMatch.newMatch((org.eclipse.gmt.modisco.java.MethodDeclaration) match[POSITION_MET]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected InvisibleMethodsMatch arrayToMatchMutable(final Object[] match) {
    try {
      return InvisibleMethodsMatch.newMutableMatch((org.eclipse.gmt.modisco.java.MethodDeclaration) match[POSITION_MET]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
