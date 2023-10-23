package tn.esprit.chatmicroservice.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.chatmicroservice.entities.Meeting;
import tn.esprit.chatmicroservice.repositories.MeetingRepository;

@RestController
@RequestMapping("/meetings")
public class MeetingController {
   
    private final MeetingRepository meetingRepository;

    @Autowired
    public MeetingController(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    @GetMapping
    public List<Meeting> getAllMeetings() {
        return meetingRepository.findAll();
    }

    @GetMapping("/{id}")
    public Meeting getMeetingById(@PathVariable Long id) {
        return meetingRepository.findById(id)
                .orElse(null); 
    }

    @PostMapping
    public Meeting createMeeting(@RequestBody Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    @PutMapping("/{id}")
    public Meeting updateMeeting(@PathVariable Long id, @RequestBody Meeting updatedMeeting) {
        Meeting existingMeeting = meetingRepository.findById(id)
                .orElse(null);

        if (existingMeeting != null) {
            existingMeeting.setTitle(updatedMeeting.getTitle());
            existingMeeting.setStartTime(updatedMeeting.getStartTime());
            existingMeeting.setEndTime(updatedMeeting.getEndTime());

            return meetingRepository.save(existingMeeting);
        }

        return null;
    }
}
