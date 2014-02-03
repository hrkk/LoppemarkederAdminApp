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

