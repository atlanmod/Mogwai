<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="Class2Relational"/>
		<constant value="links"/>
		<constant value="NTransientLinkSet;"/>
		<constant value="col"/>
		<constant value="J"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="OclParametrizedType"/>
		<constant value="#native"/>
		<constant value="Collection"/>
		<constant value="J.setName(S):V"/>
		<constant value="OclSimpleType"/>
		<constant value="OclAny"/>
		<constant value="J.setElementType(J):V"/>
		<constant value="TransientLinkSet"/>
		<constant value="A.__matcher__():V"/>
		<constant value="A.__exec__():V"/>
		<constant value="self"/>
		<constant value="__resolve__"/>
		<constant value="1"/>
		<constant value="J.oclIsKindOf(J):B"/>
		<constant value="18"/>
		<constant value="NTransientLinkSet;.getLinkBySourceElement(S):QNTransientLink;"/>
		<constant value="J.oclIsUndefined():B"/>
		<constant value="15"/>
		<constant value="NTransientLink;.getTargetFromSource(J):J"/>
		<constant value="17"/>
		<constant value="30"/>
		<constant value="Sequence"/>
		<constant value="2"/>
		<constant value="A.__resolve__(J):J"/>
		<constant value="QJ.including(J):QJ"/>
		<constant value="QJ.flatten():QJ"/>
		<constant value="e"/>
		<constant value="value"/>
		<constant value="resolveTemp"/>
		<constant value="S"/>
		<constant value="NTransientLink;.getNamedTargetFromSource(JS):J"/>
		<constant value="name"/>
		<constant value="__matcher__"/>
		<constant value="A.__matchClass2Table():V"/>
		<constant value="__exec__"/>
		<constant value="Class2Table"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applyClass2Table(NTransientLink;):V"/>
		<constant value="getName"/>
		<constant value="MClass!Class;"/>
		<constant value="0"/>
		<constant value="attr"/>
		<constant value=""/>
		<constant value="J.&lt;&gt;(J):J"/>
		<constant value="B.not():B"/>
		<constant value="CJ.including(J):CJ"/>
		<constant value="J.first():J"/>
		<constant value="11:55-11:59"/>
		<constant value="11:55-11:64"/>
		<constant value="11:76-11:77"/>
		<constant value="11:76-11:82"/>
		<constant value="11:86-11:88"/>
		<constant value="11:76-11:88"/>
		<constant value="11:55-11:89"/>
		<constant value="11:55-11:98"/>
		<constant value="__matchClass2Table"/>
		<constant value="Class"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="c"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="out"/>
		<constant value="Table"/>
		<constant value="Relational"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="18:3-20:4"/>
		<constant value="__applyClass2Table"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="J.getName():J"/>
		<constant value="19:12-19:13"/>
		<constant value="19:12-19:23"/>
		<constant value="19:4-19:23"/>
		<constant value="link"/>
	</cp>
	<field name="1" type="2"/>
	<field name="3" type="4"/>
	<operation name="5">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<push arg="7"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="9"/>
			<pcall arg="10"/>
			<dup/>
			<push arg="11"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="12"/>
			<pcall arg="10"/>
			<pcall arg="13"/>
			<set arg="3"/>
			<getasm/>
			<push arg="14"/>
			<push arg="8"/>
			<new/>
			<set arg="1"/>
			<getasm/>
			<pcall arg="15"/>
			<getasm/>
			<pcall arg="16"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="24"/>
		</localvariabletable>
	</operation>
	<operation name="18">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
		</parameters>
		<code>
			<load arg="19"/>
			<getasm/>
			<get arg="3"/>
			<call arg="20"/>
			<if arg="21"/>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<dup/>
			<call arg="23"/>
			<if arg="24"/>
			<load arg="19"/>
			<call arg="25"/>
			<goto arg="26"/>
			<pop/>
			<load arg="19"/>
			<goto arg="27"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="19"/>
			<iterate/>
			<store arg="29"/>
			<getasm/>
			<load arg="29"/>
			<call arg="30"/>
			<call arg="31"/>
			<enditerate/>
			<call arg="32"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="33" begin="23" end="27"/>
			<lve slot="0" name="17" begin="0" end="29"/>
			<lve slot="1" name="34" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="35">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
			<parameter name="29" type="36"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<load arg="19"/>
			<load arg="29"/>
			<call arg="37"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="6"/>
			<lve slot="1" name="34" begin="0" end="6"/>
			<lve slot="2" name="38" begin="0" end="6"/>
		</localvariabletable>
	</operation>
	<operation name="39">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<pcall arg="40"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="1"/>
		</localvariabletable>
	</operation>
	<operation name="41">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="42"/>
			<call arg="43"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="44"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="0" name="17" begin="0" end="9"/>
		</localvariabletable>
	</operation>
	<operation name="45">
		<context type="46"/>
		<parameters>
		</parameters>
		<code>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="47"/>
			<get arg="48"/>
			<iterate/>
			<store arg="19"/>
			<load arg="19"/>
			<get arg="38"/>
			<push arg="49"/>
			<call arg="50"/>
			<call arg="51"/>
			<if arg="24"/>
			<load arg="19"/>
			<call arg="52"/>
			<enditerate/>
			<call arg="53"/>
		</code>
		<linenumbertable>
			<lne id="54" begin="3" end="3"/>
			<lne id="55" begin="3" end="4"/>
			<lne id="56" begin="7" end="7"/>
			<lne id="57" begin="7" end="8"/>
			<lne id="58" begin="9" end="9"/>
			<lne id="59" begin="7" end="10"/>
			<lne id="60" begin="0" end="15"/>
			<lne id="61" begin="0" end="16"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="6" end="14"/>
			<lve slot="0" name="17" begin="0" end="16"/>
		</localvariabletable>
	</operation>
	<operation name="62">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="63"/>
			<push arg="63"/>
			<findme/>
			<push arg="64"/>
			<call arg="65"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="66"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="42"/>
			<pcall arg="67"/>
			<dup/>
			<push arg="68"/>
			<load arg="19"/>
			<pcall arg="69"/>
			<dup/>
			<push arg="70"/>
			<push arg="71"/>
			<push arg="72"/>
			<new/>
			<pcall arg="73"/>
			<pusht/>
			<pcall arg="74"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="75" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="68" begin="6" end="26"/>
			<lve slot="0" name="17" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="76">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="77"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="68"/>
			<call arg="78"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="70"/>
			<call arg="79"/>
			<store arg="80"/>
			<load arg="80"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<call arg="81"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="82" begin="11" end="11"/>
			<lne id="83" begin="11" end="12"/>
			<lne id="84" begin="9" end="14"/>
			<lne id="75" begin="8" end="15"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="70" begin="7" end="15"/>
			<lve slot="2" name="68" begin="3" end="15"/>
			<lve slot="0" name="17" begin="0" end="15"/>
			<lve slot="1" name="85" begin="0" end="15"/>
		</localvariabletable>
	</operation>
</asm>
