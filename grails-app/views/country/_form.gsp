<%@ page import="dk.roninit.loppadmin.Country" %>



<div class="fieldcontain ${hasErrors(bean: countryInstance, field: 'countryName', 'error')} required">
	<label for="countryName">
		<g:message code="country.countryName.label" default="Country Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="countryName" maxlength="50" required="" value="${countryInstance?.countryName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: countryInstance, field: 'countryCode', 'error')} required">
	<label for="countryCode">
		<g:message code="country.countryCode.label" default="Country Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="countryCode" maxlength="2" required="" value="${countryInstance?.countryCode}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: countryInstance, field: 'addresses', 'error')} ">
	<label for="addresses">
		<g:message code="country.addresses.label" default="Addresses" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${countryInstance?.addresses?}" var="a">
    <li><g:link controller="address" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="address" action="create" params="['country.id': countryInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'address.label', default: 'Address')])}</g:link>
</li>
</ul>

</div>

