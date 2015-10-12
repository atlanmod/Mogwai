package fr.inria.atlanmod.mogwai.incquery.queries.util;

import com.google.common.collect.Sets;
import fr.inria.atlanmod.mogwai.incquery.queries.Grabats09Match;
import fr.inria.atlanmod.mogwai.incquery.queries.Grabats09Matcher;
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
 * A pattern-specific query specification that can instantiate Grabats09Matcher in a type-safe way.
 * 
 * @see Grabats09Matcher
 * @see Grabats09Match
 * 
 */
@SuppressWarnings("all")
public final class Grabats09QuerySpecification extends BaseGeneratedEMFQuerySpecification<Grabats09Matcher> {
  private Grabats09QuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static Grabats09QuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected Grabats09Matcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return Grabats09Matcher.on(engine);
  }
  
  @Override
  public Grabats09Match newEmptyMatch() {
    return Grabats09Match.newEmptyMatch();
  }
  
  @Override
  public Grabats09Match newMatch(final Object... parameters) {
    return Grabats09Match.newMatch((org.eclipse.gmt.modisco.java.TypeDeclaration) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static Grabats09QuerySpecification INSTANCE = make();
    
    public static Grabats09QuerySpecification make() {
      return new Grabats09QuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static Grabats09QuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "fr.inria.atlanmod.mogwai.incquery.queries.grabats09";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("Tt");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("Tt", "org.eclipse.gmt.modisco.java.TypeDeclaration"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_Tt = body.getOrCreateVariableByName("Tt");
      	PVariable var_Bod = body.getOrCreateVariableByName("Bod");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      	PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_Tt, "Tt")
      	));
      	new TypeUnary(body, var_Tt, getClassifierLiteral("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf", "TypeDeclaration"), "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf/TypeDeclaration");
      	new TypeBinary(body, CONTEXT, var_Tt, var_Bod, getFeatureLiteral("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf", "AbstractTypeDeclaration", "bodyDeclarations"), "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf/AbstractTypeDeclaration.bodyDeclarations");
      	new ConstantValue(body, var__virtual_1_, true);
      	new TypeBinary(body, CONTEXT, var_Bod, var__virtual_2_, getFeatureLiteral("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf", "BodyDeclaration", "modifier"), "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf/BodyDeclaration.modifier");
      	new TypeBinary(body, CONTEXT, var__virtual_2_, var__virtual_1_, getFeatureLiteral("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf", "Modifier", "static"), "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf/Modifier.static");
      	new TypeBinary(body, CONTEXT, var_Bod, var__virtual_4_, getFeatureLiteral("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf", "MethodDeclaration", "returnType"), "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf/MethodDeclaration.returnType");
      	new TypeBinary(body, CONTEXT, var__virtual_4_, var_Tt, getFeatureLiteral("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf", "TypeAccess", "type"), "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf/TypeAccess.type");
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
