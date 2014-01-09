<%@ page import="dk.roninit.loppadmin.Address" %>



<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'createdBy', 'error')} ">
	<label for="createdBy">
		<g:message code="address.createdBy.label" default="Created By" />
		
	</label>
	<g:textField name="createdBy" value="${addressInstance?.createdBy}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'modifiedBy', 'error')} ">
	<label for="modifiedBy">
		<g:message code="address.modifiedBy.label" default="Modified By" />
		
	</label>
	<g:textField name="modifiedBy" value="${addressInstance?.modifiedBy}"/>
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

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'addressLine1', 'error')} required">
	<label for="addressLine1">
		<g:message code="address.addressLine1.label" default="Address Line1" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="addressLine1" maxlength="100" required="" value="${addressInstance?.addressLine1}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'addressLine2', 'error')} ">
	<label for="addressLine2">
		<g:message code="address.addressLine2.label" default="Address Line2" />
		
	</label>
	<g:textField name="addressLine2" maxlength="100" value="${addressInstance?.addressLine2}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'addressLine3', 'error')} ">
	<label for="addressLine3">
		<g:message code="address.addressLine3.label" default="Address Line3" />
		
	</label>
	<g:textField name="addressLine3" maxlength="100" value="${addressInstance?.addressLine3}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'postalCode', 'error')} ">
	<label for="postalCode">
		<g:message code="address.postalCode.label" default="Postal Code" />
		
	</label>
	<g:textField name="postalCode" maxlength="4" value="${addressInstance?.postalCode}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'postalArea', 'error')} ">
	<label for="postalArea">
		<g:message code="address.postalArea.label" default="Postal Area" />
		
	</label>
	<g:textField name="postalArea" maxlength="100" value="${addressInstance?.postalArea}"/>
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
    <li><g:link controller="coreMarkedItem" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="coreMarkedItem" action="create" params="['address.id': addressInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'coreMarkedItem.label', default: 'CoreMarkedItem')])}</g:link>
</li>
</ul>

</div>

