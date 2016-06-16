package fr.inria.atlanmod.mogwai.incquery.queries.util;

import com.google.common.collect.Sets;
import fr.inria.atlanmod.mogwai.incquery.queries.InvisibleMethodsMatch;
import fr.inria.atlanmod.mogwai.incquery.queries.InvisibleMethodsMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;

/**
 * A pattern-specific query specification that can instantiate InvisibleMethodsMatcher in a type-safe way.
 * 
 * @see InvisibleMethodsMatcher
 * @see InvisibleMethodsMatch
 * 
 */
@SuppressWarnings("all")
public final class InvisibleMethodsQuerySpecification extends BaseGeneratedEMFQuerySpecification<InvisibleMethodsMatcher> {
  private InvisibleMethodsQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static InvisibleMethodsQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected InvisibleMethodsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return InvisibleMethodsMatcher.on(engine);
  }
  
  @Override
  public InvisibleMethodsMatch newEmptyMatch() {
    return InvisibleMethodsMatch.newEmptyMatch();
  }
  
  @Override
  public InvisibleMethodsMatch newMatch(final Object... parameters) {
    return InvisibleMethodsMatch.newMatch((org.eclipse.gmt.modisco.java.MethodDeclaration) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static InvisibleMethodsQuerySpecification INSTANCE = make();
    
    public static InvisibleMethodsQuerySpecification make() {
      return new InvisibleMethodsQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static InvisibleMethodsQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "fr.inria.atlanmod.mogwai.incquery.queries.invisibleMethods";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("Met");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("Met", "org.eclipse.gmt.modisco.java.MethodDeclaration"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_Met = body.getOrCreateVariableByName("Met");
      	PVariable var__Cl = body.getOrCreateVariableByName("_Cl");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_Met, "Met")
      	));
      	new TypeUnary(body, var__Cl, getClassifierLiteral("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf", "ClassDeclaration"), "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf/ClassDeclaration");
      	new TypeBinary(body, CONTEXT, var__Cl, var_Met, getFeatureLiteral("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf", "AbstractTypeDeclaration", "bodyDeclarations"), "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf/AbstractTypeDeclaration.bodyDeclarations");
      	new ConstantValue(body, var__virtual_1_, getEnumLiteral("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf", "VisibilityKind", "private").getInstance());
      	new TypeUnary(body, var_Met, getClassifierLiteral("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf", "MethodDeclaration"), "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf/MethodDeclaration");
      	new TypeBinary(body, CONTEXT, var_Met, var__virtual_2_, getFeatureLiteral("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf", "BodyDeclaration", "modifier"), "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf/BodyDeclaration.modifier");
      	new TypeBinary(body, CONTEXT, var__virtual_2_, var__virtual_1_, getFeatureLiteral("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf", "Modifier", "visibility"), "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf/Modifier.visibility");
      	bodies.add(body);
      }
      {
      	PBody body = new PBody(this);
      	PVariable var_Met = body.getOrCreateVariableByName("Met");
      	PVariable var__Cl = body.getOrCreateVariableByName("_Cl");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_Met, "Met")
      	));
      	new TypeUnary(body, var__Cl, getClassifierLiteral("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf", "ClassDeclaration"), "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf/ClassDeclaration");
      	new TypeBinary(body, CONTEXT, var__Cl, var_Met, getFeatureLiteral("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf", "AbstractTypeDeclaration", "bodyDeclarations"), "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf/AbstractTypeDeclaration.bodyDeclarations");
      	new ConstantValue(body, var__virtual_1_, getEnumLiteral("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf", "VisibilityKind", "protected").getInstance());
      	new TypeUnary(body, var_Met, getClassifierLiteral("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf", "MethodDeclaration"), "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf/MethodDeclaration");
      	new TypeBinary(body, CONTEXT, var_Met, var__virtual_2_, getFeatureLiteral("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf", "BodyDeclaration", "modifier"), "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf/BodyDeclaration.modifier");
      	new TypeBinary(body, CONTEXT, var__virtual_2_, var__virtual_1_, getFeatureLiteral("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf", "Modifier", "visibility"), "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf/Modifier.visibility");
      	bodies.add(body);
      }
      	// to silence compiler error
      	if (false) throw new IncQueryException("Never", "happens");
      } catch (IncQueryException ex) {
      	throw processDependencyException(ex);
      }
      return bodies;
    }
  }
}
