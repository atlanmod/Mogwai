package fr.inria.atlanmod.mogwai.incquery.queries.util;

import com.google.common.collect.Sets;
import fr.inria.atlanmod.mogwai.incquery.queries.CommentTextMatch;
import fr.inria.atlanmod.mogwai.incquery.queries.CommentTextMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;

/**
 * A pattern-specific query specification that can instantiate CommentTextMatcher in a type-safe way.
 * 
 * @see CommentTextMatcher
 * @see CommentTextMatch
 * 
 */
@SuppressWarnings("all")
public final class CommentTextQuerySpecification extends BaseGeneratedEMFQuerySpecification<CommentTextMatcher> {
  private CommentTextQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static CommentTextQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected CommentTextMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return CommentTextMatcher.on(engine);
  }
  
  @Override
  public CommentTextMatch newEmptyMatch() {
    return CommentTextMatch.newEmptyMatch();
  }
  
  @Override
  public CommentTextMatch newMatch(final Object... parameters) {
    return CommentTextMatch.newMatch((org.eclipse.gmt.modisco.java.TextElement) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static CommentTextQuerySpecification INSTANCE = make();
    
    public static CommentTextQuerySpecification make() {
      return new CommentTextQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static CommentTextQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "fr.inria.atlanmod.mogwai.incquery.queries.commentText";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("Ff");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("Ff", "org.eclipse.gmt.modisco.java.TextElement"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_Ff = body.getOrCreateVariableByName("Ff");
      	PVariable var_Mm = body.getOrCreateVariableByName("Mm");
      	PVariable var_Cl = body.getOrCreateVariableByName("Cl");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_Ff, "Ff")
      	));
      	new TypeBinary(body, CONTEXT, var_Mm, var__virtual_0_, getFeatureLiteral("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf", "Model", "compilationUnits"), "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf/Model.compilationUnits");
      	new TypeBinary(body, CONTEXT, var__virtual_0_, var_Cl, getFeatureLiteral("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf", "CompilationUnit", "commentList"), "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf/CompilationUnit.commentList");
      	new TypeBinary(body, CONTEXT, var_Cl, var__virtual_2_, getFeatureLiteral("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf", "Javadoc", "tags"), "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf/Javadoc.tags");
      	new TypeBinary(body, CONTEXT, var__virtual_2_, var_Ff, getFeatureLiteral("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf", "TagElement", "fragments"), "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf/TagElement.fragments");
      	new TypeUnary(body, var_Ff, getClassifierLiteral("http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf", "TextElement"), "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java-neoemf/TextElement");
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
