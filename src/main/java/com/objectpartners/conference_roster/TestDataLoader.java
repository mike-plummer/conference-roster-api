package com.objectpartners.conference_roster;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.objectpartners.conference_roster.data.entities.Attendance;
import com.objectpartners.conference_roster.data.entities.Conference;
import com.objectpartners.conference_roster.data.entities.Person;
import com.objectpartners.conference_roster.data.entities.Presentation;
import com.objectpartners.conference_roster.data.repositories.AttendanceRepository;
import com.objectpartners.conference_roster.data.repositories.ConferenceRepository;
import com.objectpartners.conference_roster.data.repositories.PersonRepository;
import com.objectpartners.conference_roster.data.repositories.PresentationRepository;
import com.objectpartners.conference_roster.data.types.State;
import com.objectpartners.conference_roster.data.types.TravelMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Configuration
public class TestDataLoader {
    @Autowired
    private ConferenceRepository conferenceRepo;
    @Autowired
    private PersonRepository peopleRepo;
    @Autowired
    private PresentationRepository presentationRepo;
    @Autowired
    private AttendanceRepository attendanceRepo;

    @PostConstruct
    public void init() {
        buildPeople();
        buildConferences();
        buildPresentations();
        buildAttendance();
    }

    private void buildConferences() {
        Conference conf = new Conference();
        conf.setName("MidwestJS");
        conf.setOpiSponsored(false);
        conf.setState(State.MINNESOTA);
        conf.setCity("Minneapolis");
        conf.setStart(LocalDate.of(2017, 8, 16));
        conf.setEnd(LocalDate.of(2017, 8, 18));
        conf.setUrl("http://midwestjs.com");
        conferenceRepo.save(conf);

        conf = new Conference();
        conf.setName("KCDC");
        conf.setOpiSponsored(true);
        conf.setState(State.KANSAS);
        conf.setCity("Kansas City");
        conf.setStart(LocalDate.of(2017, 8, 2));
        conf.setEnd(LocalDate.of(2017, 8, 4));
        conf.setDiscountCode("OPI_10OFF");
        conf.setUrl("http://www.kcdc.info");
        conferenceRepo.save(conf);
    }

    private void buildPeople() {
        Person person = new Person();
        person.setName("Amelia Earheart");
        person.setEmail("amelia.earheart@objectpartners.com");
        peopleRepo.save(person);

        person = new Person();
        person.setName("Chuck Norris");
        person.setEmail("chuck.norris@objectpartners.com");
        peopleRepo.save(person);

        person = new Person();
        person.setName("Scrooge McDuck");
        person.setEmail("scrooge.mcduck@objectpartners.com");
        peopleRepo.save(person);
    }

    private void buildPresentations() {
        Person amelia = peopleRepo.findByName("Amelia Earheart");
        Person chuck = peopleRepo.findByName("Chuck Norris");

        Presentation pres = new Presentation();
        pres.setTitle("Navigating the Pacific");
        pres.setDescription("Practical examples of what not to do when circumnavigating the globe");
        pres.setCodeUrl("http://www.github.com/objectpartners/code1");
        pres.setSlidesUrl("http://www.github.com/objectpartners/slides1");
        pres.getTags().addAll(Sets.newHashSet("fail", "pacific", "flying"));
        pres.getPresenters().add(amelia);
        presentationRepo.save(pres);

        pres = new Presentation();
        pres.setTitle("Roundhouse Kicks: Obliterate your enemies");
        pres.setDescription("Walkthrough of optimal roundhouse-kick form");
        pres.setCodeUrl("http://www.github.com/objectpartners/code2");
        pres.setSlidesUrl("http://www.github.com/objectpartners/slides2");
        pres.setTags(Sets.newHashSet("kicks", "norris", "fighting"));
        pres.getPresenters().add(chuck);
        presentationRepo.save(pres);
    }

    private void buildAttendance() {
        Person amelia = peopleRepo.findByName("Amelia Earheart");
        Person chuck = peopleRepo.findByName("Chuck Norris");
        Person scrooge = peopleRepo.findByName("Scrooge McDuck");

        Conference midwestjs = conferenceRepo.findByName("MidwestJS");
        Conference kcdc = conferenceRepo.findByName("KCDC");

        Presentation pacific = presentationRepo.getAllByTagsIn(Sets.newHashSet("flying")).iterator().next();
        Presentation roundhouse = presentationRepo.getByPresentersIn(Sets.newHashSet(chuck)).iterator().next();

        Attendance attendance = new Attendance();
        attendance.setPerson(amelia);
        attendance.setConference(midwestjs);
        attendance.setStart(midwestjs.getStart().atTime(8, 0));
        attendance.setStart(midwestjs.getEnd().atTime(16, 0));
        attendance.setTravelMethod(TravelMethod.FLY);
        attendanceRepo.save(attendance);

        attendance = new Attendance();
        attendance.setPerson(amelia);
        attendance.setConference(kcdc);
        attendance.setStart(kcdc.getStart().atTime(8, 0));
        attendance.setStart(kcdc.getEnd().atTime(16, 0));
        attendance.setTravelMethod(TravelMethod.DRIVE);
        attendance.getPresentations().add(pacific);
        attendanceRepo.save(attendance);

        attendance = new Attendance();
        attendance.setPerson(chuck);
        attendance.setConference(midwestjs);
        attendance.setStart(midwestjs.getStart().atTime(8, 0));
        attendance.setStart(midwestjs.getEnd().atTime(16, 0));
        attendance.setTravelMethod(TravelMethod.FLY);
        attendance.getPresentations().add(roundhouse);
        attendanceRepo.save(attendance);

        attendance = new Attendance();
        attendance.setPerson(chuck);
        attendance.setConference(kcdc);
        attendance.setStart(kcdc.getStart().atTime(8, 0));
        attendance.setStart(kcdc.getEnd().atTime(16, 0));
        attendance.setTravelMethod(TravelMethod.DRIVE);
        attendanceRepo.save(attendance);

        attendance = new Attendance();
        attendance.setPerson(scrooge);
        attendance.setConference(midwestjs);
        attendance.setStart(midwestjs.getStart().atTime(8, 0));
        attendance.setStart(midwestjs.getEnd().atTime(16, 0));
        attendance.setTravelMethod(TravelMethod.FLY);
        attendance.getPresentations().add(roundhouse);
        attendanceRepo.save(attendance);

        attendance = new Attendance();
        attendance.setPerson(scrooge);
        attendance.setConference(kcdc);
        attendance.setStart(kcdc.getStart().atTime(8, 0));
        attendance.setStart(kcdc.getEnd().atTime(16, 0));
        attendance.setTravelMethod(TravelMethod.DRIVE);
        attendanceRepo.save(attendance);
    }
}
