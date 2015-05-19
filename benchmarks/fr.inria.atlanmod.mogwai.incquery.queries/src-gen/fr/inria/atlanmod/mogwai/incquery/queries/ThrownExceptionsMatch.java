package fr.inria.atlanmod.mogwai.incquery.queries;

import fr.inria.atlanmod.mogwai.incquery.queries.util.ThrownExceptionsQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.gmt.modisco.java.TypeAccess;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the fr.inria.atlanmod.mogwai.incquery.queries.thrownExceptions pattern,
 * to be used in conjunction with {@link ThrownExceptionsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ThrownExceptionsMatcher
 * @see ThrownExceptionsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ThrownExceptionsMatch extends BasePatternMatch {
  private TypeAccess fEx;
  
  private static List<String> parameterNames = makeImmutableList("Ex");
  
  private ThrownExceptionsMatch(final TypeAccess pEx) {
    this.fEx = pEx;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("Ex".equals(parameterName)) return this.fEx;
    return null;
  }
  
  public TypeAccess getEx() {
    return this.fEx;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("Ex".equals(parameterName) ) {
    	this.fEx = (org.eclipse.gmt.modisco.java.TypeAccess) newValue;
    	return true;
    }
    return false;
  }
  
  public void setEx(final TypeAccess pEx) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fEx = pEx;
  }
  
  @Override
  public String patternName() {
    return "fr.inria.atlanmod.mogwai.incquery.queries.thrownExceptions";
  }
  
  @Override
  public List<String> parameterNames() {
    return ThrownExceptionsMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fEx};
  }
  
  @Override
  public ThrownExceptionsMatch toImmutable() {
    return isMutable() ? newMatch(fEx) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"Ex\"=" + prettyPrintValue(fEx)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fEx == null) ? 0 : fEx.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ThrownExceptionsMatch)) { // this should be infrequent
    	if (obj == null) {
    		return false;
    	}
    	if (!(obj instanceof IPatternMatch)) {
    		return false;
    	}
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    ThrownExceptionsMatch other = (ThrownExceptionsMatch) obj;
    if (fEx == null) {if (other.fEx != null) return false;}
    else if (!fEx.equals(other.fEx)) return false;
    return true;
  }
  
  @Override
  public ThrownExceptionsQuerySpecification specification() {
    try {
    	return ThrownExceptionsQuerySpecification.instance();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException (ex);
    }
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static ThrownExceptionsMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pEx the fixed value of pattern parameter Ex, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ThrownExceptionsMatch newMutableMatch(final TypeAccess pEx) {
    return new Mutable(pEx);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pEx the fixed value of pattern parameter Ex, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ThrownExceptionsMatch newMatch(final TypeAccess pEx) {
    return new Immutable(pEx);
  }
  
  private static final class Mutable extends ThrownExceptionsMatch {
    Mutable(final TypeAccess pEx) {
      super(pEx);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ThrownExceptionsMatch {
    Immutable(final TypeAccess pEx) {
      super(pEx);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
