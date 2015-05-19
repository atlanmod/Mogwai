package fr.inria.atlanmod.mogwai.incquery.queries;

import fr.inria.atlanmod.mogwai.incquery.queries.util.InvisibleMethodsQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.gmt.modisco.java.MethodDeclaration;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the fr.inria.atlanmod.mogwai.incquery.queries.invisibleMethods pattern,
 * to be used in conjunction with {@link InvisibleMethodsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see InvisibleMethodsMatcher
 * @see InvisibleMethodsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class InvisibleMethodsMatch extends BasePatternMatch {
  private MethodDeclaration fMet;
  
  private static List<String> parameterNames = makeImmutableList("Met");
  
  private InvisibleMethodsMatch(final MethodDeclaration pMet) {
    this.fMet = pMet;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("Met".equals(parameterName)) return this.fMet;
    return null;
  }
  
  public MethodDeclaration getMet() {
    return this.fMet;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("Met".equals(parameterName) ) {
    	this.fMet = (org.eclipse.gmt.modisco.java.MethodDeclaration) newValue;
    	return true;
    }
    return false;
  }
  
  public void setMet(final MethodDeclaration pMet) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fMet = pMet;
  }
  
  @Override
  public String patternName() {
    return "fr.inria.atlanmod.mogwai.incquery.queries.invisibleMethods";
  }
  
  @Override
  public List<String> parameterNames() {
    return InvisibleMethodsMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fMet};
  }
  
  @Override
  public InvisibleMethodsMatch toImmutable() {
    return isMutable() ? newMatch(fMet) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"Met\"=" + prettyPrintValue(fMet)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fMet == null) ? 0 : fMet.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof InvisibleMethodsMatch)) { // this should be infrequent
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
    InvisibleMethodsMatch other = (InvisibleMethodsMatch) obj;
    if (fMet == null) {if (other.fMet != null) return false;}
    else if (!fMet.equals(other.fMet)) return false;
    return true;
  }
  
  @Override
  public InvisibleMethodsQuerySpecification specification() {
    try {
    	return InvisibleMethodsQuerySpecification.instance();
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
  public static InvisibleMethodsMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pMet the fixed value of pattern parameter Met, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static InvisibleMethodsMatch newMutableMatch(final MethodDeclaration pMet) {
    return new Mutable(pMet);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pMet the fixed value of pattern parameter Met, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static InvisibleMethodsMatch newMatch(final MethodDeclaration pMet) {
    return new Immutable(pMet);
  }
  
  private static final class Mutable extends InvisibleMethodsMatch {
    Mutable(final MethodDeclaration pMet) {
      super(pMet);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends InvisibleMethodsMatch {
    Immutable(final MethodDeclaration pMet) {
      super(pMet);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
