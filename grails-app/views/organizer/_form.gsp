<%@ page import="dk.roninit.loppadmin.Organizer" %>



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

<div class="fieldcontain ${hasErrors(bean: organizerInstance, field: 'phone', 'error')} ">
	<label for="phone">
		<g:message code="organizer.phone.label" default="Phone" />
		
	</label>
	<g:textField name="phone" maxlength="8" value="${organizerInstance?.phone}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: organizerInstance, field: 'enableBooking', 'error')} ">
	<label for="enableBooking">
		<g:message code="organizer.enableBooking.label" default="Enable Booking" />
		
	</label>
	<g:checkBox name="enableBooking" value="${organizerInstance?.enableBooking}" />
</div>

