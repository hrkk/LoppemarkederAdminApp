<%@ page import="dk.roninit.loppadmin.Address" %>



<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'addressLine', 'error')} required">
	<label for="addressLine">
		<g:message code="address.addressLine.label" default="Address Line" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="addressLine" maxlength="100" required="" value="${addressInstance?.addressLine}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'postalCode', 'error')} required">
	<label for="postalCode">
		<g:message code="address.postalCode.label" default="Postal Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="postalCode" maxlength="4" required="" value="${addressInstance?.postalCode}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'latitude', 'error')} required">
	<label for="latitude">
		<g:message code="address.latitude.label" default="Latitude" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="latitude" value="${fieldValue(bean: addressInstance, field: 'latitude')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'longitude', 'error')} required">
	<label for="longitude">
		<g:message code="address.longitude.label" default="Longitude" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="longitude" value="${fieldValue(bean: addressInstance, field: 'longitude')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'country', 'error')} required">
	<label for="country">
		<g:message code="address.country.label" default="Country" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="country" name="country.id" from="${dk.roninit.loppadmin.Country.list()}" optionKey="id" required="" value="${addressInstance?.country?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'markeditems', 'error')} ">
	<label for="markeditems">
		<g:message code="address.markeditems.label" default="Markeditems" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${addressInstance?.markeditems?}" var="m">
    <li><g:link controller="markedItem" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="markedItem" action="create" params="['address.id': addressInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'markedItem.label', default: 'MarkedItem')])}</g:link>
</li>
</ul>

</div>

