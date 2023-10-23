package tn.esprit.chatmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.chatmicroservice.entities.Meeting;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}
