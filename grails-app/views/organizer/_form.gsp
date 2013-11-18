<%@ page import="dk.roninit.loppadmin.Organizer" %>



<div class="fieldcontain ${hasErrors(bean: organizerInstance, field: 'firstName', 'error')} ">
	<label for="firstName">
		<g:message code="organizer.firstName.label" default="First Name" />
		
	</label>
	<g:textField name="firstName" maxlength="50" value="${organizerInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: organizerInstance, field: 'lastName', 'error')} ">
	<label for="lastName">
		<g:message code="organizer.lastName.label" default="Last Name" />
		
	</label>
	<g:textField name="lastName" maxlength="50" value="${organizerInstance?.lastName}"/>
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

<div class="fieldcontain ${hasErrors(bean: organizerInstance, field: 'markedItem', 'error')} ">
	<label for="markedItem">
		<g:message code="organizer.markedItem.label" default="Marked Item" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${organizerInstance?.markedItem?}" var="m">
    <li><g:link controller="markedItem" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="markedItem" action="create" params="['organizer.id': organizerInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'markedItem.label', default: 'MarkedItem')])}</g:link>
</li>
</ul>

</div>

