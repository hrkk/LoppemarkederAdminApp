<%@ page import="dk.roninit.loppadmin.Organizer" %>



<div class="fieldcontain ${hasErrors(bean: organizerInstance, field: 'createdBy', 'error')} ">
	<label for="createdBy">
		<g:message code="organizer.createdBy.label" default="Created By" />
		
	</label>
	<g:textField name="createdBy" value="${organizerInstance?.createdBy}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: organizerInstance, field: 'modifiedBy', 'error')} ">
	<label for="modifiedBy">
		<g:message code="organizer.modifiedBy.label" default="Modified By" />
		
	</label>
	<g:textField name="modifiedBy" value="${organizerInstance?.modifiedBy}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: organizerInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="organizer.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="50" required="" value="${organizerInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: organizerInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="organizer.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="email" required="" value="${organizerInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: organizerInstance, field: 'phone', 'error')} required">
	<label for="phone">
		<g:message code="organizer.phone.label" default="Phone" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="phone" maxlength="8" required="" value="${organizerInstance?.phone}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: organizerInstance, field: 'enableBooking', 'error')} ">
	<label for="enableBooking">
		<g:message code="organizer.enableBooking.label" default="Enable Booking" />
		
	</label>
	<g:checkBox name="enableBooking" value="${organizerInstance?.enableBooking}" />
</div>

<div class="fieldcontain ${hasErrors(bean: organizerInstance, field: 'markedItem', 'error')} ">
	<label for="markedItem">
		<g:message code="organizer.markedItem.label" default="Marked Item" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${organizerInstance?.markedItem?}" var="m">
    <li><g:link controller="coreMarkedItem" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="coreMarkedItem" action="create" params="['organizer.id': organizerInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'coreMarkedItem.label', default: 'CoreMarkedItem')])}</g:link>
</li>
</ul>

</div>

