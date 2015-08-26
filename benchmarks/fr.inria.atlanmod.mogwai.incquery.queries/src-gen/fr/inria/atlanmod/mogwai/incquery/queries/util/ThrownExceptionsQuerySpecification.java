package fr.inria.atlanmod.mogwai.incquery.queries.util;

import com.google.common.collect.Sets;
import fr.inria.atlanmod.mogwai.incquery.queries.ThrownExceptionsMatch;
import fr.inria.atlanmod.mogwai.incquery.queries.ThrownExceptionsMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

/**
 * A pattern-specific query specification that can instantiate ThrownExceptionsMatcher in a type-safe way.
 * 
 * @see ThrownExceptionsMatcher
 * @see ThrownExceptionsMatch
 * 
 */
@SuppressWarnings("all")
public final class ThrownExceptionsQuerySpecification extends BaseGeneratedQuerySpecification<ThrownExceptionsMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ThrownExceptionsQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected ThrownExceptionsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ThrownExceptionsMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "fr.inria.atlanmod.mogwai.incquery.queries.thrownExceptions";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("Ex");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("Ex", "org.eclipse.gmt.modisco.java.TypeAccess"));
  }
  
  @Override
  public ThrownExceptionsMatch newEmptyMatch() {
    return ThrownExceptionsMatch.newEmptyMatch();
  }
  
  @Override
  public ThrownExceptionsMatch newMatch(final Object... parameters) {
    return ThrownExceptionsMatch.newMatch((org.eclipse.gmt.modisco.java.TypeAccess) parameters[0]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_Ex = body.getOrCreateVariableByName("Ex");
      PVariable var_Pack = body.getOrCreateVariableByName("Pack");
      PVariable var_Owned = body.getOrCreateVariableByName("Owned");
      PVariable var_Body = body.getOrCreateVariableByName("Body");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_Ex, "Ex")
      ));
      
      new TypeBinary(body, CONTEXT, var_Pack, var_Owned, getFeatureLiteral("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf", "Package", "ownedElements"), "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf/Package.ownedElements");
      new TypeUnary(body, var_Owned, getClassifierLiteral("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf", "ClassDeclaration"), "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf/ClassDeclaration");
      new TypeBinary(body, CONTEXT, var_Owned, var_Body, getFeatureLiteral("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf", "AbstractTypeDeclaration", "bodyDeclarations"), "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf/AbstractTypeDeclaration.bodyDeclarations");
      new TypeUnary(body, var_Body, getClassifierLiteral("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf", "MethodDeclaration"), "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf/MethodDeclaration");
      new TypeBinary(body, CONTEXT, var_Body, var_Ex, getFeatureLiteral("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf", "AbstractMethodDeclaration", "thrownExceptions"), "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf/AbstractMethodDeclaration.thrownExceptions");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static ThrownExceptionsQuerySpecification INSTANCE = make();
    
    public static ThrownExceptionsQuerySpecification make() {
      return new ThrownExceptionsQuerySpecification();					
      
    }
  }
}
