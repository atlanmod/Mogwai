package fr.inria.atlanmod.mogwai.incquery.queries;

import fr.inria.atlanmod.mogwai.incquery.queries.util.Grabats09QuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.gmt.modisco.java.TypeDeclaration;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the fr.inria.atlanmod.mogwai.incquery.queries.grabats09 pattern,
 * to be used in conjunction with {@link Grabats09Matcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see Grabats09Matcher
 * @see Grabats09Processor
 * 
 */
@SuppressWarnings("all")
public abstract class Grabats09Match extends BasePatternMatch {
  private TypeDeclaration fTt;
  
  private static List<String> parameterNames = makeImmutableList("Tt");
  
  private Grabats09Match(final TypeDeclaration pTt) {
    this.fTt = pTt;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("Tt".equals(parameterName)) return this.fTt;
    return null;
  }
  
  public TypeDeclaration getTt() {
    return this.fTt;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("Tt".equals(parameterName) ) {
    	this.fTt = (org.eclipse.gmt.modisco.java.TypeDeclaration) newValue;
    	return true;
    }
    return false;
  }
  
  public void setTt(final TypeDeclaration pTt) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTt = pTt;
  }
  
  @Override
  public String patternName() {
    return "fr.inria.atlanmod.mogwai.incquery.queries.grabats09";
  }
  
  @Override
  public List<String> parameterNames() {
    return Grabats09Match.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fTt};
  }
  
  @Override
  public Grabats09Match toImmutable() {
    return isMutable() ? newMatch(fTt) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"Tt\"=" + prettyPrintValue(fTt)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fTt == null) ? 0 : fTt.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof Grabats09Match)) { // this should be infrequent
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
    Grabats09Match other = (Grabats09Match) obj;
    if (fTt == null) {if (other.fTt != null) return false;}
    else if (!fTt.equals(other.fTt)) return false;
    return true;
  }
  
  @Override
  public Grabats09QuerySpecification specification() {
    try {
    	return Grabats09QuerySpecification.instance();
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
  public static Grabats09Match newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pTt the fixed value of pattern parameter Tt, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static Grabats09Match newMutableMatch(final TypeDeclaration pTt) {
    return new Mutable(pTt);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pTt the fixed value of pattern parameter Tt, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static Grabats09Match newMatch(final TypeDeclaration pTt) {
    return new Immutable(pTt);
  }
  
  private static final class Mutable extends Grabats09Match {
    Mutable(final TypeDeclaration pTt) {
      super(pTt);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends Grabats09Match {
    Immutable(final TypeDeclaration pTt) {
      super(pTt);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
