Doctors {
	id integer pk increments > Schedule.idDoctor
	firstName varchar(50)
	lastName varchar(50)
	idSpecialty integer
}

Rooms {
	id integer pk > Schedule.idRoom
	cabinetNumber integer
}

staffPhoneNumbers {
	id integer pk increments
	phoneNumber integer
	idDoctor integer > Doctors.id
}

Specialty {
	id integer pk increments > Doctors.idSpecialty
	specialty varchar
}

Schedule {
	id integer pk increments
	idPatient integer
	appointment datetime
	idDoctor integer
	idRoom integer
}

Patient {
	id integer pk increments > Schedule.idPatient
	firstName varchar
	lastName varchar
	idPhoneNember integer
	idPatientChart integer
}

PatientCharts {
	id integer pk increments
	idPatient integer > Patient.id
	PatientChart blob
}

patientPhoneNumbers {
	id integer pk increments > Patient.idPhoneNember
	phoneNumber integer
}

MedicalTests {
	id integer pk increments
	date datetime
	idPatient integer > Patient.id
	idDoctor integer > Doctors.id
	idType integer
	idPatientCharts integer > PatientCharts.id
}

patientAppointments {
	id integer pk increments
	idDoctor integer > Doctors.id
	idPatient integer > Patient.id
	description varchar def(300)
}

typeMedicalTests {
	id integer pk increments > MedicalTests.idType
	title varchar
	description integer
	costs decimal
