package com.example.library_management.Services;

import com.example.library_management.Entities.BorrowRecord;
import com.example.library_management.Repositories.BookRepository;
import com.example.library_management.Repositories.BorrowRecordRepository;
import com.example.library_management.Repositories.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowRecordService {

    private final BorrowRecordRepository repo;
    private final BookRepository bookRepo;
    private final MemberRepository memberRepo;

    public BorrowRecordService(BorrowRecordRepository repo, BookRepository bookRepo, MemberRepository memberRepo) {
        this.repo = repo;
        this.bookRepo = bookRepo;
        this.memberRepo = memberRepo;
    }

    public List<BorrowRecord> findAll() { return repo.findAll(); }

    public BorrowRecord findBorrowRecordById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("BorrowRecord not found"));
    }

    public BorrowRecord save(BorrowRecord record) {
        return repo.save(record);
    }

    public void deleteBorrowRecordById(Long id) { repo.deleteById(id); }
}

