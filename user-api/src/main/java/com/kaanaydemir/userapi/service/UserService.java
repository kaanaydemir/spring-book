package com.kaanaydemir.userapi.service;

import com.google.gson.Gson;
import com.kaanaydemir.userapi.client.BookClient;
import com.kaanaydemir.userapi.dto.KafkaReadListDto;
import com.kaanaydemir.userapi.dto.UserDto;
import com.kaanaydemir.userapi.entity.User;
import com.kaanaydemir.userapi.kafka.KafkaTopicConfig;
import com.kaanaydemir.userapi.mapper.UserMapper;
import com.kaanaydemir.userapi.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BookClient bookClient;
    private final KafkaProducerService kafkaProducerService;
    private final KafkaTopicConfig kafkaTopicConfig;

    public UserService(UserRepository userRepository, UserMapper userMapper, BookClient bookClient,
                       KafkaProducerService kafkaProducerService, KafkaTopicConfig kafkaTopicConfig) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.bookClient = bookClient;
        this.kafkaProducerService = kafkaProducerService;
        this.kafkaTopicConfig = kafkaTopicConfig;
    }

    public Long save(UserDto userDto) {
        User user = userMapper.convert(userDto);
        User save = userRepository.save(user);
        return save.getId();
    }

    public UserDto findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(RuntimeException::new);
        return userMapper.convert(user);
    }

    public void addBookToReadList(Long userId, Long bookId) {

        boolean isUserExist = userRepository.existsById(userId);

        if(!isUserExist) {
            throw new RuntimeException("User not found!");
        }

        if (!bookClient.isBookExist(bookId)) {
            throw new RuntimeException("Book not found!");
        }
        KafkaReadListDto kafkaReadListDto = new KafkaReadListDto(userId, bookId);
        Gson gson = new Gson();
        String message = gson.toJson(kafkaReadListDto);

        kafkaProducerService.sendMessage(kafkaTopicConfig.readListTopic().name(), message);

    }


}
