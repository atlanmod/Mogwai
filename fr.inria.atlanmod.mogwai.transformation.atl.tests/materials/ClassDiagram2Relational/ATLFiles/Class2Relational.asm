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
		<constant value="A.__matchAttribute2Column():V"/>
		<constant value="__exec__"/>
		<constant value="Class2Table"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applyClass2Table(NTransientLink;):V"/>
		<constant value="Attribute2Column"/>
		<constant value="A.__applyAttribute2Column(NTransientLink;):V"/>
		<constant value="__matchClass2Table"/>
		<constant value="Class"/>
		<constant value="ClassMM"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="Person"/>
		<constant value="J.=(J):J"/>
		<constant value="B.not():B"/>
		<constant value="39"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="c"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="out"/>
		<constant value="Table"/>
		<constant value="RelationalMM"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="out2"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="14:22-14:23"/>
		<constant value="14:22-14:28"/>
		<constant value="14:31-14:39"/>
		<constant value="14:22-14:39"/>
		<constant value="16:3-19:4"/>
		<constant value="20:3-22:4"/>
		<constant value="__applyClass2Table"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="4"/>
		<constant value="attr"/>
		<constant value="J.first():J"/>
		<constant value="17:12-17:13"/>
		<constant value="17:12-17:18"/>
		<constant value="17:4-17:18"/>
		<constant value="18:11-18:12"/>
		<constant value="18:11-18:17"/>
		<constant value="18:11-18:26"/>
		<constant value="18:4-18:26"/>
		<constant value="21:12-21:13"/>
		<constant value="21:12-21:18"/>
		<constant value="21:4-21:18"/>
		<constant value="link"/>
		<constant value="__matchAttribute2Column"/>
		<constant value="Attribute"/>
		<constant value="a"/>
		<constant value="fKey"/>
		<constant value="Column"/>
		<constant value="29:3-31:4"/>
		<constant value="__applyAttribute2Column"/>
		<constant value="Id"/>
		<constant value="J.+(J):J"/>
		<constant value="30:12-30:13"/>
		<constant value="30:12-30:18"/>
		<constant value="30:21-30:25"/>
		<constant value="30:12-30:25"/>
		<constant value="30:4-30:25"/>
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
			<getasm/>
			<pcall arg="41"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="3"/>
		</localvariabletable>
	</operation>
	<operation name="42">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="43"/>
			<call arg="44"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="45"/>
			<enditerate/>
			<getasm/>
			<get arg="1"/>
			<push arg="46"/>
			<call arg="44"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="47"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="1" name="33" begin="15" end="18"/>
			<lve slot="0" name="17" begin="0" end="19"/>
		</localvariabletable>
	</operation>
	<operation name="48">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="49"/>
			<push arg="50"/>
			<findme/>
			<push arg="51"/>
			<call arg="52"/>
			<iterate/>
			<store arg="19"/>
			<load arg="19"/>
			<get arg="38"/>
			<push arg="53"/>
			<call arg="54"/>
			<call arg="55"/>
			<if arg="56"/>
			<getasm/>
			<get arg="1"/>
			<push arg="57"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="43"/>
			<pcall arg="58"/>
			<dup/>
			<push arg="59"/>
			<load arg="19"/>
			<pcall arg="60"/>
			<dup/>
			<push arg="61"/>
			<push arg="62"/>
			<push arg="63"/>
			<new/>
			<pcall arg="64"/>
			<dup/>
			<push arg="65"/>
			<push arg="62"/>
			<push arg="63"/>
			<new/>
			<pcall arg="64"/>
			<pusht/>
			<pcall arg="66"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="67" begin="7" end="7"/>
			<lne id="68" begin="7" end="8"/>
			<lne id="69" begin="9" end="9"/>
			<lne id="70" begin="7" end="10"/>
			<lne id="71" begin="25" end="30"/>
			<lne id="72" begin="31" end="36"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="59" begin="6" end="38"/>
			<lve slot="0" name="17" begin="0" end="39"/>
		</localvariabletable>
	</operation>
	<operation name="73">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="74"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="59"/>
			<call arg="75"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="61"/>
			<call arg="76"/>
			<store arg="77"/>
			<load arg="19"/>
			<push arg="65"/>
			<call arg="76"/>
			<store arg="78"/>
			<load arg="77"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="38"/>
			<call arg="30"/>
			<set arg="38"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="79"/>
			<call arg="80"/>
			<call arg="30"/>
			<set arg="3"/>
			<pop/>
			<load arg="78"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="38"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="81" begin="15" end="15"/>
			<lne id="82" begin="15" end="16"/>
			<lne id="83" begin="13" end="18"/>
			<lne id="84" begin="21" end="21"/>
			<lne id="85" begin="21" end="22"/>
			<lne id="86" begin="21" end="23"/>
			<lne id="87" begin="19" end="25"/>
			<lne id="71" begin="12" end="26"/>
			<lne id="88" begin="30" end="30"/>
			<lne id="89" begin="30" end="31"/>
			<lne id="90" begin="28" end="33"/>
			<lne id="72" begin="27" end="34"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="61" begin="7" end="34"/>
			<lve slot="4" name="65" begin="11" end="34"/>
			<lve slot="2" name="59" begin="3" end="34"/>
			<lve slot="0" name="17" begin="0" end="34"/>
			<lve slot="1" name="91" begin="0" end="34"/>
		</localvariabletable>
	</operation>
	<operation name="92">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="93"/>
			<push arg="50"/>
			<findme/>
			<push arg="51"/>
			<call arg="52"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="57"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="46"/>
			<pcall arg="58"/>
			<dup/>
			<push arg="94"/>
			<load arg="19"/>
			<pcall arg="60"/>
			<dup/>
			<push arg="95"/>
			<push arg="96"/>
			<push arg="63"/>
			<new/>
			<pcall arg="64"/>
			<pusht/>
			<pcall arg="66"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="97" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="94" begin="6" end="26"/>
			<lve slot="0" name="17" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="98">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="74"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="94"/>
			<call arg="75"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="95"/>
			<call arg="76"/>
			<store arg="77"/>
			<load arg="77"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="38"/>
			<push arg="99"/>
			<call arg="100"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="101" begin="11" end="11"/>
			<lne id="102" begin="11" end="12"/>
			<lne id="103" begin="13" end="13"/>
			<lne id="104" begin="11" end="14"/>
			<lne id="105" begin="9" end="16"/>
			<lne id="97" begin="8" end="17"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="95" begin="7" end="17"/>
			<lve slot="2" name="94" begin="3" end="17"/>
			<lve slot="0" name="17" begin="0" end="17"/>
			<lve slot="1" name="91" begin="0" end="17"/>
		</localvariabletable>
	</operation>
</asm>
