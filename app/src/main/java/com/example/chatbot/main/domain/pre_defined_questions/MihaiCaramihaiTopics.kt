package com.example.chatbot.main.domain.pre_defined_questions

import com.example.chatbot.main.data.question_metadata_database.entity.TopicMetadata
import com.example.chatbot.main.data.question_metadata_database.entity.QuestionMetadata


val predefinedTopics by lazy {
        listOf<TopicMetadata>(
            TopicMetadata(
                uid = 0,
                label = "Types and formats of digital contentTypes and formats of digital content",
                keyWords = listOf<String>(),
                imageUid = -1
            ),
            TopicMetadata(
                uid = 1,
                label = "Artificial Intelligence (AI) Generated Content",
                keyWords = listOf(),
                imageUid = -1
            ),
            TopicMetadata(
                2, label = "Accessibility incorporation in digital content",
                keyWords = listOf(), imageUid = -1
            ),
            TopicMetadata(
                uid = 3,
                label = "Virtual reality, augmented reality and mixed reality",
                keyWords = listOf(),
                imageUid = -1
            ),
            TopicMetadata(
                uid = 4,
                label = "Digital content on personal, professional, and open platforms",
                keyWords = listOf(),
                imageUid = -1
            ),
            TopicMetadata(
                uid = 5,
                label = "Data visualisation, Data manipulation, Data attribution",
                keyWords = listOf(),
                imageUid = -1
            ),
            TopicMetadata(
                uid = 6,
                label = "SEO and digital marketing",
                keyWords = listOf(),
                imageUid = -1
            ),
            TopicMetadata(
                uid = 7,
                label = "Protection techniques and mechanisms for copyrighting",
                keyWords = listOf(),
                imageUid = -1
            ),
            TopicMetadata(uid = 7, label = "Licences", keyWords = listOf(), imageUid = -1)
        )
    }

val topic1Questions by lazy {
    listOf(
        // Set 1
        QuestionMetadata(
            uid = 0,
            grade = -1f,
            statusCode = 0,
            questionUid = 0,
            questionContent = "Have I analyzed audience feedback and comments to identify areas for improvement and refinement in my content?",
            correctAnswer = "Yes, analyzing audience feedback and comments is essential to identify areas for improvement and refinement in content.",
            topicUid = 0,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 1,
            grade = -1f,
            statusCode = 0,
            questionUid = 1,
            questionContent = "Am I regularly updating my digital content with the latest data, statistics, and industry trends to keep it relevant and valuable?",
            correctAnswer = "Yes, regularly updating digital content with the latest data, statistics, and industry trends is crucial to keep it relevant and valuable.",
            topicUid = 0,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 2,
            grade = -1f,
            statusCode = 0,
            questionUid = 2,
            questionContent = "Do I leverage multimedia elements, such as images, videos, and interactive elements, to enhance the visual appeal and engagement of my content?",
            correctAnswer = "Yes, leveraging multimedia elements, such as images, videos, and interactive elements, enhances the visual appeal and engagement of content.",
            topicUid = 0,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 3,
            grade = -1f,
            statusCode = 0,
            questionUid = 3,
            questionContent = "Have I integrated interactive elements, such as polls, quizzes, or calls-to-action, to encourage audience participation and create a more immersive experience?",
            correctAnswer = "Yes, integrating interactive elements, such as polls, quizzes, or calls-to-action, encourages audience participation and creates a more immersive experience.",
            topicUid = 0,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 4,
            grade = -1f,
            statusCode = 0,
            questionUid = 4,
            questionContent = "Am I optimizing my digital content for search engines by using relevant keywords, meta tags, and internal linking to improve its visibility and search rankings?",
            correctAnswer = "Yes, optimizing digital content for search engines by using relevant keywords, meta tags, and internal linking improves its visibility and search rankings.",
            topicUid = 0,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 5,
            grade = -1f,
            statusCode = 0,
            questionUid = 5,
            questionContent = "What is the purpose of refining digital content?",
            correctAnswer = "To ensure clarity, accuracy, and consistency, making it more effective and relevant to the target audience.",
            topicUid = 0,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 6,
            grade = -1f,
            statusCode = 0,
            questionUid = 6,
            questionContent = "How can multimedia elements enhance digital content?",
            correctAnswer = "By captivating the audience's attention, increasing engagement, and making the content more visually appealing.",
            topicUid = 0,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 7,
            grade = -1f,
            statusCode = 0,
            questionUid = 7,
            questionContent = "What are some examples of interactive elements that can be integrated into digital content?",
            correctAnswer = "Quizzes, polls, and calls-to-action.",
            topicUid = 0,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 8,
            grade = -1f,
            statusCode = 0,
            questionUid = 8,
            questionContent = "Why is updating digital content with the latest information and industry trends important?",
            correctAnswer = "To keep the content accurate, relevant, and valuable to the audience.",
            topicUid = 0,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 9,
            grade = -1f,
            statusCode = 0,
            questionUid = 9,
            questionContent = "How does integrating user feedback contribute to content improvement?",
            correctAnswer = "By allowing content creators to address the audience's needs and preferences, making the content more effective.",
            topicUid = 0,
            weight = 10.0
        ),

        // Set 2
        QuestionMetadata(
            uid = 10,
            grade = -1f,
            statusCode = 0,
            questionUid = 0,
            questionContent = "What are the main types of text-based digital content?",
            correctAnswer = "Articles, blog posts, ebooks, and whitepapers.",
            topicUid = 0,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 11,
            grade = -1f,
            statusCode = 0,
            questionUid = 11,
            questionContent = "Name two formats commonly used for interactive digital content.",
            correctAnswer = "Quizzes and interactive infographics.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 12,
            grade = -1f,
            statusCode = 0,
            questionUid = 12,
            questionContent = "How can businesses use social media content to engage with their audience effectively?",
            correctAnswer = "Creating and sharing valuable and relevant content that addresses their audience's needs and interests.",
            topicUid = 0,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 13,
            grade = -1f,
            statusCode = 0,
            questionUid = 13,
            questionContent = "Give an example of a digital content format that can be used to showcase product features and benefits.",
            correctAnswer = "An explainer video.",
            topicUid = 0,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 14,
            grade = -1f,
            statusCode = 0,
            questionUid = 14,
            questionContent = "Explain how virtual and augmented reality content can enhance user experiences.",
            correctAnswer = "Virtual and augmented reality content can enhance user experiences by providing immersive and interactive experiences that blend digital elements with the real world.",
            topicUid = 0,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 15,
            grade = -1f,
            statusCode = 0,
            questionUid = 15,
            questionContent = "What are some common examples of visual content used in digital marketing?",
            correctAnswer = "Infographics.",
            topicUid = 0,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 16,
            grade = -1f,
            statusCode = 0,
            questionUid = 16,
            questionContent = "Explain the difference between webinars and online courses as digital content formats.",
            correctAnswer = "Webinars are live or pre-recorded online events that focus on a specific topic or subject; they are more interactive and allow real-time engagement with the audience.",
            topicUid = 0,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 17,
            grade = -1f,
            statusCode = 0,
            questionUid = 17,
            questionContent = "How can user-generated content be leveraged to benefit a brand's digital marketing strategy?",
            correctAnswer = "User-generated content provides genuine feedback and testimonials from real customers, which can enhance the brand's credibility and build trust with potential customers.",
            topicUid = 0,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 18,
            grade = -1f,
            statusCode = 0,
            questionUid = 18,
            questionContent = "Name two formats commonly used for delivering audio content to the audience.",
            correctAnswer = "Podcasts and audiobooks.",
            topicUid = 0,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 19,
            grade = -1f,
            statusCode = 0,
            questionUid = 19,
            questionContent = "How can businesses use infographics to effectively communicate complex information?",
            correctAnswer = "Presenting data visually.",
            topicUid = 0,
            weight = 10.0
        ),

        // Set 3
        QuestionMetadata(
            uid = 20,
            grade = -1f,
            statusCode = 0,
            questionUid = 20,
            questionContent = "Have I explored a diverse range of sources, including articles, data, images, and videos, to gather different items of content and information?",
            correctAnswer = "Yes, exploring a diverse range of sources, including articles, data, images, and videos, is essential to gather different items of content and information.",
            topicUid = 0,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 21,
            grade = -1f,
            statusCode = 0,
            questionUid = 21,
            questionContent = "Did I identify common themes and connections among the various content items to create a cohesive narrative for the new content?",
            correctAnswer = "Yes, identifying common themes and connections among the various content items is crucial to create a cohesive narrative for the new content.",
            topicUid = 0,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 22,
            grade = -1f,
            statusCode = 0,
            questionUid = 22,
            questionContent = "Have I added my own unique insights and perspectives to bring a fresh and original angle to the content?",
            correctAnswer = "Yes, adding your own unique insights and perspectives is important to bring a fresh and original angle to the content.",
            topicUid = 0,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 23,
            grade = -1f,
            statusCode = 0,
            questionUid = 23,
            questionContent = "Did I integrate multimedia elements, such as images, videos, and infographics, to enhance the visual appeal of the new content?",
            correctAnswer = "Yes, integrating multimedia elements, such as images, videos, and infographics, enhances the visual appeal of the new content.",
            topicUid = 0,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 24,
            grade = -1f,
            statusCode = 0,
            questionUid = 24,
            questionContent = "Have I incorporated interactive elements, such as polls, quizzes, or calls-to-action, to create a more engaging and participative experience for the audience?",
            correctAnswer = "Yes, incorporating interactive elements, such as polls, quizzes, or calls-to-action, creates a more engaging and participative experience for the audience.",
            topicUid = 0,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 25,
            grade = -1f,
            statusCode = 0,
            questionUid = 25,
            questionContent = "Why is it important to explore a diverse range of sources, such as articles, data, images, and videos, when gathering content for creating new and original digital content?",
            correctAnswer = "It provides a variety of perspectives and insights for a more comprehensive and unique content creation.",
            topicUid = 0,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 26,
            grade = -1f,
            statusCode = 0,
            questionUid = 26,
            questionContent = "How does identifying common themes and connections among the various content items contribute to the creation of a cohesive narrative?",
            correctAnswer = "By helping to create a logical flow and structure, ensuring the content is well-connected and coherent.",
            topicUid = 0,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 27,
            grade = -1f,
            statusCode = 0,
            questionUid = 27,
            questionContent = "Why is adding your own unique insights and perspectives essential when creating new digital content?",
            correctAnswer = "Adding your own unique insights and perspectives is essential when creating new digital content because it brings a fresh and original angle to the content, making it unique and engaging.",
            topicUid = 0,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 28,
            grade = -1f,
            statusCode = 0,
            questionUid = 28,
            questionContent = "How do multimedia elements, such as images, videos, and infographics, enhance the visual appeal of digital content?",
            correctAnswer = "Multimedia elements enhance the visual appeal of digital content by captivating the audience's attention and making the content more visually appealing and engaging.",
            topicUid = 0,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 29,
            grade = -1f,
            statusCode = 0,
            questionUid = 29,
            "What is the purpose of incorporating interactive elements, such as polls, quizzes, or calls-to-action, in digital content?",
            "Incorporating interactive elements in digital content is to create a more engaging and participative experience, encouraging audience interaction and feedback.",
            0,
            10.0
        )
    )
}
val topic2Questions by lazy {
    val questions = listOf(
        // Set 1 (UIDs 30-59)
        QuestionMetadata(
            uid = 30,
            grade = -1f,
            statusCode = 0,
            questionUid = 30,
            questionContent = "What is the purpose of refining digital content?",
            correctAnswer = "To ensure clarity, accuracy, and consistency, making it more effective and relevant to the target audience.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 31,
            grade = -1f,
            statusCode = 0,
            questionUid = 31,
            questionContent = "How can multimedia elements enhance digital content?",
            correctAnswer = "By captivating the audience's attention, increasing engagement, and making the content more visually appealing.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 32,
            grade = -1f,
            statusCode = 0,
            questionUid = 32,
            questionContent = "What are some examples of interactive elements that can be integrated into digital content?",
            correctAnswer = "Quizzes, polls, and calls-to-action.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 33,
            grade = -1f,
            statusCode = 0,
            questionUid = 33,
            questionContent = "Why is updating digital content with the latest information and industry trends important?",
            correctAnswer = "To keep the content accurate, relevant, and valuable to the audience.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 34,
            grade = -1f,
            statusCode = 0,
            questionUid = 34,
            questionContent = "How does integrating user feedback contribute to content improvement?",
            correctAnswer = "By allowing content creators to address the audience's needs and preferences, making the content more effective.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 35,
            grade = -1f,
            statusCode = 0,
            questionUid = 35,
            questionContent = "What are the main types of text-based digital content?",
            correctAnswer = "Articles, blog posts, ebooks, and whitepapers.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 36,
            grade = -1f,
            statusCode = 0,
            questionUid = 36,
            questionContent = "Name two formats commonly used for interactive digital content.",
            correctAnswer = "Quizzes and interactive infographics.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 37,
            grade = -1f,
            statusCode = 0,
            questionUid = 37,
            questionContent = "How can businesses use social media content to engage with their audience effectively?",
            correctAnswer = "Creating and sharing valuable and relevant content that addresses their audience's needs and interests.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 38,
            grade = -1f,
            statusCode = 0,
            questionUid = 38,
            questionContent = "Give an example of a digital content format that can be used to showcase product features and benefits.",
            correctAnswer = "An explainer video.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 39,
            grade = -1f,
            statusCode = 0,
            questionUid = 39,
            questionContent = "Explain how virtual and augmented reality content can enhance user experiences.",
            correctAnswer = "Virtual and augmented reality content can enhance user experiences by providing immersive and interactive experiences that blend digital elements with the real world.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 40,
            grade = -1f,
            statusCode = 0,
            questionUid = 40,
            questionContent = "What are some common examples of visual content used in digital marketing?",
            correctAnswer = "Infographics.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 41,
            grade = -1f,
            statusCode = 0,
            questionUid = 41,
            questionContent = "Explain the difference between webinars and online courses as digital content formats.",
            correctAnswer = "Webinars are live or pre-recorded online events that focus on a specific topic or subject; they are more interactive and allow real-time engagement with the audience.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 42,
            grade = -1f,
            statusCode = 0,
            questionUid = 42,
            questionContent = "How can user-generated content be leveraged to benefit a brand's digital marketing strategy?",
            correctAnswer = "User-generated content provides genuine feedback and testimonials from real customers, which can enhance the brand's credibility and build trust with potential customers.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 43,
            grade = -1f,
            statusCode = 0,
            questionUid = 43,
            questionContent = "Name two formats commonly used for delivering audio content to the audience.",
            correctAnswer = "Podcasts and audiobooks.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 44,
            grade = -1f,
            statusCode = 0,
            questionUid = 44,
            questionContent = "How can businesses use infographics to effectively communicate complex information?",
            correctAnswer = "Presenting data visually.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 45,
            grade = -1f,
            statusCode = 0,
            questionUid = 45,
            questionContent = "Have I explored a diverse range of sources, including articles, data, images, and videos, to gather different items of content and information?",
            correctAnswer = "Yes, exploring a diverse range of sources, including articles, data, images, and videos, is essential to gather different items of content and information.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 46,
            grade = -1f,
            statusCode = 0,
            questionUid = 46,
            questionContent = "Did I identify common themes and connections among the various content items to create a cohesive narrative for the new content?",
            correctAnswer = "Yes, identifying common themes and connections among the various content items is crucial to create a cohesive narrative for the new content.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 47,
            grade = -1f,
            statusCode = 0,
            questionUid = 47,
            questionContent = "Have I added my own unique insights and perspectives to bring a fresh and original angle to the content?",
            correctAnswer = "Yes, adding your own unique insights and perspectives is important to bring a fresh and original angle to the content.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 48,
            grade = -1f,
            statusCode = 0,
            questionUid = 48,
            questionContent = "Did I integrate multimedia elements, such as images, videos, and infographics, to enhance the visual appeal of the new content?",
            correctAnswer = "Yes, integrating multimedia elements, such as images, videos, and infographics, enhances the visual appeal of the new content.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 49,
            grade = -1f,
            statusCode = 0,
            questionUid = 49,
            questionContent = "Have I incorporated interactive elements, such as polls, quizzes, or calls-to-action, to create a more engaging and participative experience for the audience?",
            correctAnswer = "Yes, incorporating interactive elements, such as polls, quizzes, or calls-to-action, creates a more engaging and participative experience for the audience.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 50,
            grade = -1f,
            statusCode = 0,
            questionUid = 50,
            questionContent = "Why is it important to explore a diverse range of sources, such as articles, data, images, and videos, when gathering content for creating new and original digital content?",
            correctAnswer = "It provides a variety of perspectives and insights for a more comprehensive and unique content creation.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 51,
            grade = -1f,
            statusCode = 0,
            questionUid = 51,
            questionContent = "How does identifying common themes and connections among the various content items contribute to the creation of a cohesive narrative?",
            correctAnswer = "By helping to create a logical flow and structure, ensuring the content is well-connected and coherent.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 52,
            grade = -1f,
            statusCode = 0,
            questionUid = 52,
            questionContent = "Why is adding your own unique insights and perspectives essential when creating new digital content?",
            correctAnswer = "Adding your own unique insights and perspectives is essential when creating new digital content because it brings a fresh and original angle to the content, making it unique and engaging.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 53,
            grade = -1f,
            statusCode = 0,
            questionUid = 53,
            questionContent = "How do multimedia elements, such as images, videos, and infographics, enhance the visual appeal of digital content?",
            correctAnswer = "Multimedia elements enhance the visual appeal of digital content by captivating the audience's attention and making the content more visually appealing and engaging.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 54,
            grade = -1f,
            statusCode = 0,
            questionUid = 54,
            questionContent = "How does integrating user feedback contribute to content improvement?",
            correctAnswer = "By allowing content creators to address the audience's needs and preferences, making the content more effective.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 55,
            grade = -1f,
            statusCode = 0,
            questionUid = 55,
            questionContent = "Why is updating digital content with the latest information and industry trends important?",
            correctAnswer = "To keep the content accurate, relevant, and valuable to the audience.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 56,
            grade = -1f,
            statusCode = 0,
            questionUid = 56,
            questionContent = "How does identifying common themes and connections among the various content items contribute to the creation of a cohesive narrative?",
            correctAnswer = "By helping to create a logical flow and structure, ensuring the content is well-connected and coherent.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 57,
            grade = -1f,
            statusCode = 0,
            questionUid = 57,
            questionContent = "Why is adding your own unique insights and perspectives essential when creating new digital content?",
            correctAnswer = "Adding your own unique insights and perspectives is essential when creating new digital content because it brings a fresh and original angle to the content, making it unique and engaging.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 58,
            grade = -1f,
            statusCode = 0,
            questionUid = 58,
            questionContent = "How do multimedia elements, such as images, videos, and infographics, enhance the visual appeal of digital content?",
            correctAnswer = "Multimedia elements enhance the visual appeal of digital content by captivating the audience's attention and making the content more visually appealing and engaging.",
            topicUid = 1,
            weight = 10.0
        ),
        QuestionMetadata(
            uid = 59,
            grade = -1f,
            statusCode = 0,
            questionUid = 59,
            questionContent = "What is the purpose of refining digital content?",
            correctAnswer = "To ensure clarity, accuracy, and consistency, making it more effective and relevant to the target audience.",
            topicUid = 1,
            weight = 10.0
        ),
    )
}

val topic3Questions by lazy {

    listOf(
        QuestionMetadata(
            60,
            -1f,
            0,
            60,
            "What is the primary purpose of following WCAG guidelines in web development?\n- To make web content more accessible to people with disabilities",
            "To make web content more accessible to people with disabilities",
            2,
            10.0
        ),
        QuestionMetadata(
            61,
            -1f,
            0,
            61,
            "Which HTML element is crucial for adding alternative text to images for screen readers?\n- <img> with the alt attribute",
            "<img> with the alt attribute",
            2,
            10.0
        ),
        QuestionMetadata(
            62,
            -1f,
            0,
            62,
            "When implementing keyboard navigation, which aspect is most important?\n- Ensuring that all content can be navigated using keyboard controls",
            "Ensuring that all content can be navigated using keyboard controls",
            2,
            10.0
        ),
        QuestionMetadata(
            63,
            -1f,
            0,
            63,
            "Which of the following would not be a part of your accessibility checklist?\n- Page view counts",
            "Page view counts",
            2,
            10.0
        ),
        QuestionMetadata(
            64,
            -1f,
            0,
            64,
            "Why is captioning multimedia content important?\n- It provides a textual alternative for those who cannot hear the audio",
            "It provides a textual alternative for those who cannot hear the audio",
            2,
            10.0
        ),
        QuestionMetadata(
            65,
            -1f,
            0,
            65,
            "In the context of accessible web development, what does 'screen reader compatibility' mean?\n- The website can be navigated and understood using screen reader software",
            "The website can be navigated and understood using screen reader software",
            2,
            10.0
        ),
        QuestionMetadata(
            66,
            -1f,
            0,
            66,
            "Which CSS property is important for ensuring sufficient contrast between text and background?\n- color contrast",
            "color contrast",
            2,
            10.0
        ),
        QuestionMetadata(
            67,
            -1f,
            0,
            67,
            "What kind of testing is crucial after developing an accessible website?\n- Accessibility testing",
            "Accessibility testing",
            2,
            10.0
        ),
        QuestionMetadata(
            68,
            -1f,
            0,
            68,
            "What does the term 'user experience' encompass in accessible web design?\n- The experience of users with disabilities as well as those without",
            "The experience of users with disabilities as well as those without",
            2,
            10.0
        ),
        QuestionMetadata(
            69,
            -1f,
            0,
            69,
            "Which automated tool can be used for accessibility testing?\n- WAVE (Web Accessibility Evaluation Tool)",
            "WAVE (Web Accessibility Evaluation Tool)",
            2,
            10.0
        ),


        QuestionMetadata(
            70,
            -1f,
            0,
            70,
            "When modifying form inputs to be more accessible, what is a crucial feature to add?\n- Error handling and descriptive labels",
            "Error handling and descriptive labels",
            2,
            10.0
        ),
        QuestionMetadata(
            71,
            -1f,
            0,
            71,
            "What kind of testing is important after implementing new accessibility features?\n- Usability testing with participants who have disabilities",
            "Usability testing with participants who have disabilities",
            2,
            10.0
        ),
        QuestionMetadata(
            72,
            -1f,
            0,
            72,
            "Why are alternative texts for images important?\n- They describe the image for users who cannot see it",
            "They describe the image for users who cannot see it",
            2,
            10.0
        ),
        QuestionMetadata(
            73,
            -1f,
            0,
            73,
            "Which web development tool can be used to check for accessibility compliance?\n- Automated accessibility checking tools",
            "Automated accessibility checking tools",
            2,
            10.0
        ),
        QuestionMetadata(
            74,
            -1f,
            0,
            5,
            "In terms of accessibility, what does proper tab indexing influence?\n- The order in which elements are focused during keyboard navigation",
            "The order in which elements are focused during keyboard navigation",
            2,
            10.0
        ),
        QuestionMetadata(
            75,
            -1f,
            0,
            75,
            "What is the benefit of adding captions to video content?\n- Captions provide a textual representation of the audio for hearing-impaired users",
            "Captions provide a textual representation of the audio for hearing-impaired users",
            2,
            10.0
        ),
        QuestionMetadata(
            76,
            -1f,
            0,
            76,
            "How can interactivity be maintained for users with limited mobility when designing web content?\n- By ensuring all interactive elements are operable with keyboard commands",
            "By ensuring all interactive elements are operable with keyboard commands",
            2,
            10.0
        ),
        QuestionMetadata(
            77,
            -1f,
            0,
            77,
            "Why is color contrast important in web design for accessibility?\n- It ensures text is legible to users with visual impairments.",
            "It ensures text is legible to users with visual impairments.",
            2,
            10.0
        ),
        QuestionMetadata(
            78,
            -1f,
            0,
            78,
            "What is an outcome of successful accessibility enhancements in web development?\n- The website becomes usable by a wider range of users, including those with disabilities.",
            "The website becomes usable by a wider range of users, including those with disabilities.",
            2,
            10.0
        ),
        QuestionMetadata(
            79,
            -1f,
            0,
            79,
            "Which approach is least effective in creating accessible web content?\n- Adding accessibility features as an afterthought",
            "Adding accessibility features as an afterthought",
            2,
            10.0
        ),


        QuestionMetadata(
            80,
            -1f,
            0,
            80,
            "What is the primary goal of empathy mapping in accessible content creation?\n- To understand the experiences and needs of users with disabilities",
            "To understand the experiences and needs of users with disabilities",
            2,
            10.0
        ),
        QuestionMetadata(
            81,
            -1f,
            0,
            81,
            "Universal design principles in digital content creation aim to:\n- Create content that is accessible and usable by all people",
            "Create content that is accessible and usable by all people",
            2,
            10.0
        ),
        QuestionMetadata(
            82,
            -1f,
            0,
            82,
            "When setting benchmarks for inclusion, what are participants primarily focusing on?\n- The level of accessibility and usability for diverse users",
            "The level of accessibility and usability for diverse users",
            2,
            10.0
        ),
        QuestionMetadata(
            83,
            -1f,
            0,
            83,
            "Which technology can be used to generate descriptive alt text for visual content?\n- Artificial Intelligence",
            "Artificial Intelligence",
            2,
            10.0
        ),
        QuestionMetadata(
            84,
            -1f,
            0,
            84,
            "Interactive voice response systems are implemented in web browsing to assist users who:\n- Have difficulty using traditional navigation methods",
            "Have difficulty using traditional navigation methods",
            2,
            10.0
        ),
        QuestionMetadata(
            85,
            -1f,
            0,
            85,
            "Semantic HTML is used in accessible web design to:\n- Create a clear structure that assists screen readers and other assistive technologies",
            "Create a clear structure that assists screen readers and other assistive technologies",
            2,
            10.0
        ),
        QuestionMetadata(
            86,
            -1f,
            0,
            86,
            "Responsive design practices ensure that digital content is:\n- Consistently accessible across a range of devices and screen sizes",
            "Consistently accessible across a range of devices and screen sizes",
            2,
            10.0
        ),
        QuestionMetadata(
            87,
            -1f,
            0,
            87,
            "What aspect of digital content is evaluated using automated accessibility tools?\n- Compliance with accessibility standards",
            "Compliance with accessibility standards",
            2,
            10.0
        ),
        QuestionMetadata(
            88,
            -1f,
            0,
            88,
            "How does AI contribute to web accessibility?\n- By generating alternative text for images",
            "By generating alternative text for images",
            2,
            10.0
        ),
        QuestionMetadata(
            89,
            -1f,
            0,
            89,
            "In accessible content strategy, layout considerations should:\n- Prioritize ease of navigation and logical structure for all users",
            "Prioritize ease of navigation and logical structure for all users",
            2,
            10.0
        )
    )
}

val topic4Questions by lazy {
    listOf(
        QuestionMetadata(
            90,
            -1f,
            0,
            90,
            "Which of the following is NOT a common technology used in VR, AR, and MR systems?\n- Microphone",
            "Microphone",
            3,
            10.0
        ),
        QuestionMetadata(
            91,
            -1f,
            0,
            91,
            "What is the primary purpose of a Motion Tracking System?\n- To track the user's head and body movements",
            "To track the user's head and body movements",
            3,
            10.0
        ),
        QuestionMetadata(
            92,
            -1f,
            0,
            92,
            "Which of the following statements is TRUE about VR systems?\n- VR systems use HMDs to completely block out the real world and display a virtual environment.",
            "VR systems use HMDs to completely block out the real world and display a virtual environment.",
            3,
            10.0
        ),
        QuestionMetadata(
            93,
            -1f,
            0,
            93,
            "Which of the following statements is TRUE about AR systems?\n- AR systems use HMDs or other wearable devices to display digital information onto the real world",
            "AR systems use HMDs or other wearable devices to display digital information onto the real world",
            3,
            10.0
        ),
        QuestionMetadata(
            94,
            -1f,
            0,
            94,
            "Which of the following statements is TRUE about MR systems?\n- MR systems combine elements of both VR and AR to create experiences that blend the real and virtual worlds.",
            "MR systems combine elements of both VR and AR to create experiences that blend the real and virtual worlds.",
            3,
            10.0
        ),
        QuestionMetadata(
            95,
            -1f,
            0,
            95,
            "Which of the following is NOT a common application for VR systems?\n- Video conferencing",
            "Video conferencing",
            3,
            10.0
        ),
        QuestionMetadata(
            96,
            -1f,
            0,
            96,
            "Which of the following is NOT a common application for MR systems?\n- Customer service",
            "Customer service",
            3,
            10.0
        ),
        QuestionMetadata(
            97,
            -1f,
            0,
            97,
            "Which of the following is the MOST important factor to consider when choosing a VR headset?\n- Field of view",
            "Field of view",
            3,
            10.0
        ),
        QuestionMetadata(
            98,
            -1f,
            0,
            98,
            "What is the MOST promising potential application for VR, AR, and MR systems?\n- Healthcare",
            "Healthcare",
            3,
            10.0
        ),
        QuestionMetadata(
            99,
            -1f,
            0,
            99,
            "Which of the following statements is the MOST accurate prediction about the future of VR, AR, and MR systems?\n- VR, AR, and MR systems will be used for a wide range of applications, including gaming, education, healthcare, and manufacturing.",
            "VR, AR, and MR systems will be used for a wide range of applications, including gaming, education, healthcare, and manufacturing.",
            3,
            10.0
        ),


        QuestionMetadata(
            100,
            -1f,
            0,
            100,
            "Which of the following is NOT an example of modifying a VR, AR, or MR experience?\n- Integrating two or more experiences",
            "Integrating two or more experiences",
            3,
            10.0
        ),
        QuestionMetadata(
            101,
            -1f,
            0,
            101,
            "What is the most important thing to consider when modifying a VR, AR, or MR experience?\n- The user experience",
            "The user experience",
            3,
            10.0
        ),
        QuestionMetadata(
            102,
            -1f,
            0,
            102,
            "Which of the following is NOT an example of refining a VR, AR, or MR experience?\n- Adding new content",
            "Adding new content",
            3,
            10.0
        ),
        QuestionMetadata(
            103,
            -1f,
            0,
            103,
            "What is the most important thing to consider when refining a VR, AR, or MR experience?\n- The user feedback",
            "The user feedback",
            3,
            10.0
        ),
        QuestionMetadata(
            104,
            -1f,
            0,
            104,
            "Which of the following is NOT an example of improving a VR, AR, or MR experience?\n- Removing content",
            "Removing content",
            3,
            10.0
        ),
        QuestionMetadata(
            105,
            -1f,
            0,
            105,
            "What is the most important thing to consider when improving a VR, AR, or MR experience?\n- The user needs",
            "The user needs",
            3,
            10.0
        ),
        QuestionMetadata(
            106,
            -1f,
            0,
            106,
            "Which of the following is NOT an example of integrating VR, AR, and MR experiences?\n- Replacing VR, AR, and MR experiences with traditional experiences",
            "Replacing VR, AR, and MR experiences with traditional experiences",
            3,
            10.0
        ),
        QuestionMetadata(
            107,
            -1f,
            0,
            107,
            "Which of the following is NOT a challenge of integrating VR, AR, and MR?\n- Market acceptance challenges",
            "Market acceptance challenges",
            3,
            10.0
        ),
        QuestionMetadata(
            108,
            -1f,
            0,
            108,
            "Which of the following is NOT an opportunity of integrating VR, AR, and MR?\n- Reduced costs",
            "Reduced costs",
            3,
            10.0
        ),


        QuestionMetadata(
            109,
            -1f,
            0,
            109,
            "Which tool is commonly used for developing Virtual Reality experiences?\n- Unity",
            "Unity",
            3,
            10.0
        ),
        QuestionMetadata(
            110,
            -1f,
            0,
            110,
            "Which of the following best describes Mixed Reality (MR)?\n- Combines elements of both VR and AR",
            "Combines elements of both VR and AR",
            3,
            10.0
        ),
        QuestionMetadata(
            111,
            -1f,
            0,
            111,
            "What is the primary component for user immersion in VR?\n- Graphics",
            "Graphics",
            3,
            10.0
        ),
        QuestionMetadata(
            112,
            -1f,
            0,
            112,
            "What ethical aspect is crucial in VR/AR/MR development?\n- User Safety",
            "User Safety",
            3,
            10.0
        ),
        QuestionMetadata(
            113,
            -1f,
            0,
            113,
            "Which language is commonly used for VR programming?\n- C#",
            "C#",
            3,
            10.0
        ),
        QuestionMetadata(
            114,
            -1f,
            0,
            114,
            "What is the main goal of integrating elements across VR, AR, and MR platforms?\n- Seamless User Experience",
            "Seamless User Experience",
            3,
            10.0
        ),
        QuestionMetadata(
            115,
            -1f,
            0,
            115,
            "What does VR provide that AR doesn't?\n- Fully immersive environment",
            "Fully immersive environment",
            3,
            10.0
        ),
        QuestionMetadata(
            116,
            -1f,
            0,
            116,
            "What is the key challenge in MR integration?\n- Complexity",
            "Complexity",
            3,
            10.0
        ),
        QuestionMetadata(
            117,
            -1f,
            0,
            117,
            "In AR, what is used to place virtual objects in the real world?\n- Anchor points",
            "Anchor points",
            3,
            10.0
        ),
        QuestionMetadata(
            118,
            -1f,
            0,
            118,
            "What is one of the ethical considerations when creating a VR experience?\n- Data Privacy",
            "Data Privacy",
            3,
            10.0
        ),
    )
}
val topic5Questions by lazy {
    val questionsSet7 = listOf(
        QuestionMetadata(
            119,
            -1f,
            0,
            119,
            "Which of the following is NOT a type of digital content?\n- Print material",
            "Print material",
            4,
            10.0
        ),
        QuestionMetadata(
            120,
            -1f,
            0,
            120,
            "Which platform is NOT typically used for sharing digital content with a global audience?\n- Email",
            "Email",
            4,
            10.0
        ),
        QuestionMetadata(
            121,
            -1f,
            0,
            121,
            "Which of the following is NOT a tip for creating high-quality digital content?\n- Plagiarize other people's work",
            "Plagiarize other people's work",
            4,
            10.0
        ),
        QuestionMetadata(
            122,
            -1f,
            0,
            122,
            "Which of the following is NOT an ethical consideration when creating and sharing digital content?\n- Sharing personal information without permission",
            "Sharing personal information without permission",
            4,
            10.0
        ),
        QuestionMetadata(
            123,
            -1f,
            0,
            123,
            "Which of the following is NOT a step in the process of creating and sharing high-quality digital content?\n- Ignore peer review",
            "Ignore peer review",
            4,
            10.0
        ),


        QuestionMetadata(
            124,
            -1f,
            0,
            124,
            "What is an open-access platform?\n- A platform with unrestricted access to content",
            "A platform with unrestricted access to content",
            4,
            10.0
        ),
        QuestionMetadata(
            125,
            -1f,
            0,
            125,
            "Which is not a social media platform?\n- Google Search",
            "Google Search",
            4,
            10.0
        ),
        QuestionMetadata(
            126,
            -1f,
            0,
            126,
            "What is clickbait?\n- A misleading headline to get clicks",
            "A misleading headline to get clicks",
            4,
            10.0
        ),
        QuestionMetadata(
            127,
            -1f,
            0,
            127,
            "Which of the following criteria is NOT important for assessing the quality of digital content?\n- Content is visually appealing",
            "Content is visually appealing",
            4,
            10.0
        ),
        QuestionMetadata(
            128,
            -1f,
            0,
            128,
            "Which of the following is NOT an ethical consideration when promoting your digital content?\n- Pay for fake social media followers",
            "Pay for fake social media followers",
            4,
            10.0
        ),


        QuestionMetadata(
            129,
            -1f,
            0,
            129,
            "What is the primary objective of content modification?\n- To improve user experience",
            "To improve user experience",
            4,
            10.0
        ),
        QuestionMetadata(
            130,
            -1f,
            0,
            130,
            "Which tool is commonly used for text editing?\n- Microsoft Word",
            "Microsoft Word",
            4,
            10.0
        ),
        QuestionMetadata(
            131,
            -1f,
            0,
            131,
            "What does content integration involve?\n- Combining different types of content",
            "Combining different types of content",
            4,
            10.0
        ),
        QuestionMetadata(
            132,
            -1f,
            0,
            132,
            "Which of the following is NOT a best practice for modifying and improving existing digital content?\n- Use a lot of jargon and technical terms",
            "Use a lot of jargon and technical terms",
            4,
            10.0
        ),
        QuestionMetadata(
            133,
            -1f,
            0,
            133,
            "Which of the following is a good way to optimize your content for search engines?\n- Use relevant keywords throughout your content.",
            "Use relevant keywords throughout your content.",
            4,
            10.0
        ),


        QuestionMetadata(
            134,
            -1f,
            0,
            134,
            "What is the main goal of using data analytics in content refinement?\n- To make data-driven decisions",
            "To make data-driven decisions",
            4,
            10.0
        ),
        QuestionMetadata(
            135,
            -1f,
            0,
            135,
            "Why is user feedback crucial for content improvement?\n- It provides valuable insights",
            "It provides valuable insights",
            4,
            10.0
        ),
        QuestionMetadata(
            136,
            -1f,
            0,
            136,
            "What is the primary consideration in content improvement?\n- User Experience",
            "User Experience",
            4,
            10.0
        ),
        QuestionMetadata(
            137,
            -1f,
            0,
            137,
            "Which of the following is NOT a cross-platform integration technique?\n- Use proprietary content formats",
            "Use proprietary content formats",
            4,
            10.0
        ),
        QuestionMetadata(
            138,
            -1f,
            0,
            138,
            "Which of the following is NOT a key performance indicator (KPI) for digital content?\n- Brand awareness",
            "Brand awareness",
            4,
            10.0
        ),


        QuestionMetadata(
            139,
            -1f,
            0,
            139,
            "What is an essential aspect of creating original content for personal platforms?\n- Personal Branding",
            "Personal Branding",
            4,
            10.0
        ),
        QuestionMetadata(
            140,
            -1f,
            0,
            140,
            "Which tool is commonly used for professional content creation?\n- Adobe Creative Suite",
            "Adobe Creative Suite",
            4,
            10.0
        ),
        QuestionMetadata(
            141,
            -1f,
            0,
            141,
            "Which of the following is an ethical consideration in content creation?\n- Copyright Laws",
            "Copyright Laws",
            4,
            10.0
        ),
        QuestionMetadata(
            142,
            -1f,
            0,
            142,
            "What does a content strategy typically include?\n- Target Audience",
            "Target Audience",
            4,
            10.0
        ),
        QuestionMetadata(
            143,
            -1f,
            0,
            143,
            "Which element should not be part of your portfolio?\n- Plagiarized Content",
            "Plagiarized Content",
            4,
            10.0
        ),
        QuestionMetadata(
            144,
            -1f,
            0,
            144,
            "Which of the following is NOT a good practice for cross-platform optimization?\n- Use proprietary content formats.",
            "Use proprietary content formats.",
            4,
            10.0
        ),
        QuestionMetadata(
            145,
            -1f,
            0,
            145,
            "Which of the following is NOT a good way to optimize your images for web viewing?\n- Use high-resolution images.",
            "Use high-resolution images.",
            4,
            10.0
        ),
        QuestionMetadata(
            146,
            -1f,
            0,
            146,
            "Which of the following is NOT a responsive design principle?\n- Use fixed widths and heights.",
            "Use fixed widths and heights.",
            4,
            10.0
        ),
        QuestionMetadata(
            147,
            -1f,
            0,
            147,
            "Which of the following is NOT a way to be inspired by other creators?\n- Copy other creators' work",
            "Copy other creators' work",
            4,
            10.0
        ),
        QuestionMetadata(
            148,
            -1f,
            0,
            148,
            "Which of the following is NOT a good way to experiment with different techniques and styles?\n- Be afraid to fail.",
            "Be afraid to fail.",
            4,
            10.0
        ),
    )
}
val topic6Questions by lazy {
    listOf(
        QuestionMetadata(
            149,
            -1f,
            0,
            149,
            "Which of the following tools is primarily used for data visualization?\n- Excel",
            "Excel",
            5,
            10.0
        ),
        QuestionMetadata(
            150,
            -1f,
            0,
            150,
            "Which of the following best describes data attribution?\n- Crediting the source of data",
            "Crediting the source of data",
            5,
            10.0
        ),
        QuestionMetadata(
            151,
            -1f,
            0,
            151,
            "What does data manipulation primarily involve?\n- Changing Data Structure",
            "Changing Data Structure",
            5,
            10.0
        ),
        QuestionMetadata(
            152,
            -1f,
            0,
            152,
            "What is intellectual property in the context of data attribution?\n- Acknowledging data source",
            "Acknowledging data source",
            5,
            10.0
        ),
        QuestionMetadata(
            153,
            -1f,
            0,
            153,
            "What does ethical data sourcing primarily aim to ensure?\n- Data Integrity",
            "Data Integrity",
            5,
            10.0
        ),
        QuestionMetadata(
            154,
            -1f,
            0,
            154,
            "Which of the following should you avoid in data visualization?\n- 3D effects",
            "3D effects",
            5,
            10.0
        ),
        QuestionMetadata(
            155,
            -1f,
            0,
            155,
            "In terms of data manipulation, what does 'joining' mean?\n- Combining two datasets",
            "Combining two datasets",
            5,
            10.0
        ),
        QuestionMetadata(
            156,
            -1f,
            0,
            156,
            "What is the main objective of data attribution?\n- To ensure data integrity and ethical use",
            "To ensure data integrity and ethical use",
            5,
            10.0
        ),
        QuestionMetadata(
            157,
            -1f,
            0,
            157,
            "Which of the following is NOT a data manipulation task?\n- Visualizing data",
            "Visualizing data",
            5,
            10.0
        ),
        QuestionMetadata(
            158,
            -1f,
            0,
            158,
            "Which of the following is NOT an important ethical consideration for data collection, storage, use, and sharing?\n- Data ownership",
            "Data ownership",
            5,
            10.0
        ),


        QuestionMetadata(
            159,
            -1f,
            0,
            159,
            "Which of the following is NOT a best practice for modifying, refining, and improving data manipulation?\n- Data",
            "Data",
            5,
            10.0
        ),
        QuestionMetadata(
            160,
            -1f,
            0,
            160,
            "Which of the following is NOT a common data manipulation technique?\n- Visualizing",
            "Visualizing",
            5,
            10.0
        ),
        QuestionMetadata(
            161,
            -1f,
            0,
            161,
            "Which of the following data manipulation techniques is used to identify and correct errors and inconsistencies in data?\n- Cleaning",
            "Cleaning",
            5,
            10.0
        ),
        QuestionMetadata(
            162,
            -1f,
            0,
            162,
            "Which of the following data manipulation techniques is used to combine data from multiple sources into a single dataset?\n- Merging",
            "Merging",
            5,
            10.0
        ),
        QuestionMetadata(
            163,
            -1f,
            0,
            163,
            "Which of the following criteria is NOT important for evaluating the effectiveness of data manipulation techniques?\n- Transparency",
            "Transparency",
            5,
            10.0
        ),
        QuestionMetadata(
            164,
            -1f,
            0,
            164,
            "What is the first step in a data manipulation challenge?\n- Selecting a dataset",
            "Selecting a dataset",
            5,
            10.0
        ),
        QuestionMetadata(
            165,
            -1f,
            0,
            165,
            "Which task involves organizing data into categories?\n- Grouping",
            "Grouping",
            5,
            10.0
        ),
        QuestionMetadata(
            166,
            -1f,
            0,
            166,
            "What function is used to change the orientation of the dataset?\n- Transposing",
            "Transposing",
            5,
            10.0
        ),
        QuestionMetadata(
            167,
            -1f,
            0,
            167,
            "Which tool can be used for data manipulation tasks?\n- Excel",
            "Excel",
            5,
            10.0
        ),
        QuestionMetadata(
            168,
            -1f,
            0,
            168,
            "What is the purpose of filtering data?\n- To display only the rows that meet certain criteria",
            "To display only the rows that meet certain criteria",
            5,
            10.0
        ),


        QuestionMetadata(
            169,
            -1f,
            0,
            169,
            "What is the primary objective of the Data Visualization Challenge?\n- To create an interactive visualization of a complex dataset in Excel",
            "To create an interactive visualization of a complex dataset in Excel",
            5,
            10.0
        ),
        QuestionMetadata(
            170,
            -1f,
            0,
            170,
            "Which tool is recommended for the Data Visualization Challenge?\n- Microsoft Excel",
            "Microsoft Excel",
            5,
            10.0
        ),
        QuestionMetadata(
            171,
            -1f,
            0,
            171,
            "What is a key task in the Data Manipulation Challenge?\n- Data cleaning",
            "Data cleaning",
            5,
            10.0
        ),
        QuestionMetadata(
            172,
            -1f,
            0,
            172,
            "Data wrangling, often performed in the Data Manipulation Challenge, primarily involves:\n- Transforming and mapping data from one format to another",
            "Transforming and mapping data from one format to another",
            5,
            10.0
        ),
        QuestionMetadata(
            173,
            -1f,
            0,
            173,
            "In the Data Attribution Challenge, what are students required to do?\n- Identify the data sources used in a visualization or publication",
            "Identify the data sources used in a visualization or publication",
            5,
            10.0
        ),
        QuestionMetadata(
            174,
            -1f,
            0,
            174,
            "For effective data visualization, what is a crucial aspect to consider?\n- Making the visualization interactive and engaging",
            "Making the visualization interactive and engaging",
            5,
            10.0
        ),
        QuestionMetadata(
            175,
            -1f,
            0,
            175,
            "In the context of Excel, what feature is often used for interactive data visualizations?\n- Pivot Tables",
            "Pivot Tables",
            5,
            10.0
        ),
        QuestionMetadata(
            176,
            -1f,
            0,
            176,
            "When identifying data sources in the Data Attribution Challenge, students must look for:\n- The original source of the data used in the visualization",
            "The original source of the data used in the visualization",
            5,
            10.0
        ),
        QuestionMetadata(
            177,
            -1f,
            0,
            177,
            "What is a common outcome of data cleaning in the Data Manipulation Challenge?\n- A more accurate and reliable dataset",
            "A more accurate and reliable dataset",
            5,
            10.0
        ),
        QuestionMetadata(
            178,
            -1f,
            0,
            178,
            "During the Data Attribution Challenge, what indicates a credible data source?\n- A source that is well-documented and transparent",
            "A source that is well-documented and transparent",
            5,
            10.0
        ),
    )

}

val topic7Questions by lazy {
    listOf(
        QuestionMetadata(
            179,
            -1f,
            0,
            179,
            "What is the role of Search Engine Optimization (SEO)?\n- Improving organic traffic to a webpage/website.",
            "Improving organic traffic to a webpage/website.",
            6,
            10.0
        ),
        QuestionMetadata(
            180,
            -1f,
            0,
            180,
            "From the perspective of digital marketing, is SEO sufficient?\n- No, paid advertising, social media marketing, email marketing, and content marketing complements SEO in bringing customers to a website.",
            "No, paid advertising, social media marketing, email marketing, and content marketing complements SEO in bringing customers to a website.",
            6,
            10.0
        ),
        QuestionMetadata(
            181,
            -1f,
            0,
            181,
            "Which of the following represent Search Engine Optimization tools?\n- Ahrefs, Moz, and Screaming Frog.",
            "Ahrefs, Moz, and Screaming Frog.",
            6,
            10.0
        ),
        QuestionMetadata(
            182,
            -1f,
            0,
            182,
            "How can you identify issues such as broken links, duplicate content, and site speed problems?\n- By conducting a comprehensive audit of a website's SEO performance.",
            "By conducting a comprehensive audit of a website's SEO performance.",
            6,
            10.0
        ),


        QuestionMetadata(
            183,
            -1f,
            0,
            183,
            "What is the primary goal of on-page SEO optimization?\n- Optimizing elements within the web page to enhance its chances of ranking higher in a SERP.",
            "Optimizing elements within the web page to enhance its chances of ranking higher in a SERP.",
            6,
            10.0
        ),
        QuestionMetadata(
            184,
            -1f,
            0,
            184,
            "What is the primary goal of social media marketing for businesses?\n- Develop and improve the brand, engage the audience, and promote the products.",
            "Develop and improve the brand, engage the audience, and promote the products.",
            6,
            10.0
        ),
        QuestionMetadata(
            185,
            -1f,
            0,
            185,
            "How can you optimize a website for mobile SEO?\n- Ensure that the site is mobile-friendly and provides a positive user experience for visitors accessing it from mobile devices.",
            "Ensure that the site is mobile-friendly and provides a positive user experience for visitors accessing it from mobile devices.",
            6,
            10.0
        ),
        QuestionMetadata(
            186,
            -1f,
            0,
            186,
            "How can A/B testing benefit email marketing campaigns?\n- Provides valuable insights into which elements of the emails are most effective at engaging recipients.",
            "Provides valuable insights into which elements of the emails are most effective at engaging recipients.",
            6,
            10.0
        ),
        QuestionMetadata(
            187,
            -1f,
            0,
            187,
            "Define keyword density in the context of SEO.\n- Keyword density is the ratio of a given keyword to all the other words on a web page.",
            "Keyword density is the ratio of a given keyword to all the other words on a web page.",
            6,
            10.0
        ),


        QuestionMetadata(
            188,
            -1f,
            0,
            188,
            "What is the purpose of a content marketing calendar, and how does it help in content planning?\n- Provides a clear picture of what content will be developed, when it will be released, and who is accountable for its development.",
            "Provides a clear picture of what content will be developed, when it will be released, and who is accountable for its development.",
            6,
            10.0
        ),
        QuestionMetadata(
            189,
            -1f,
            0,
            189,
            "How does site speed impact SEO, and what are some ways to improve it?\n- Site speed impacts ranking and user experience, and it can be improved by On-Page SEO.",
            "Site speed impacts ranking and user experience, and it can be improved by On-Page SEO.",
            6,
            10.0
        ),
        QuestionMetadata(
            190,
            -1f,
            0,
            190,
            "How can marketing automation improve the efficiency of email marketing campaigns?\n- It streamlines various tasks like personalizing content and optimizing communication with subscribers.",
            "It streamlines various tasks like personalizing content and optimizing communication with subscribers.",
            6,
            10.0
        ),
        QuestionMetadata(
            191,
            -1f,
            0,
            191,
            "What are backlinks?\n- Backlinks are hyperlinks from one website to another.",
            "Backlinks are hyperlinks from one website to another.",
            6,
            10.0
        ),
        QuestionMetadata(
            192,
            -1f,
            0,
            192,
            "Briefly explain the concept of customer segmentation.\n- The process of categorizing a target audience into distinct groups based on shared characteristics or behaviors.",
            "The process of categorizing a target audience into distinct groups based on shared characteristics or behaviors.",
            6,
            10.0
        ),


        QuestionMetadata(
            193,
            -1f,
            0,
            193,
            "Explain the difference between a 'do-follow' and a 'no-follow' link\n- 'do-follow' links are considered when crawling a webpage, while 'no-follow' links are not.",
            "'do-follow' links are considered when crawling a webpage, while 'no-follow' links are not.",
            6,
            10.0
        ),
        QuestionMetadata(
            194,
            -1f,
            0,
            194,
            "Define the term 'conversion rate' in the context of digital marketing.\n- Refers to the percentage of website visitors that become customers.",
            "Refers to the percentage of website visitors that become customers.",
            6,
            10.0
        ),
        QuestionMetadata(
            195,
            -1f,
            0,
            195,
            "What is an XML sitemap?\n- An XML sitemap is a structured file that lists the URLs of a website's pages, along with additional metadata about each page.",
            "An XML sitemap is a structured file that lists the URLs of a website's pages, along with additional metadata about each page.",
            6,
            10.0
        ),
        QuestionMetadata(
            196,
            -1f,
            0,
            196,
            "Explain the concept of pay-per-click (PPC) advertising.\n- PPC is a digital advertising model in which advertisers pay a fee each time one of their ads is clicked by a user.",
            "PPC is a digital advertising model in which advertisers pay a fee each time one of their ads is clicked by a user.",
            6,
            10.0
        ),
        QuestionMetadata(
            197,
            -1f,
            0,
            197,
            "What is the role of alt (alternative) text in SEO?\n- The role of alt text is to provide a textual description of an image on a web page.",
            "The role of alt text is to provide a textual description of an image on a web page.",
            6,
            10.0
        ),


        QuestionMetadata(
            198,
            -1f,
            0,
            198,
            "What are the key components of an effective landing page for online advertising.\n- A compelling headline, engaging visuals, trust indicators, and key benefits and features of the offer or product.",
            "A compelling headline, engaging visuals, trust indicators, and key benefits and features of the offer or product.",
            6,
            10.0
        ),
        QuestionMetadata(
            199,
            -1f,
            0,
            199,
            "Describe the concept of long-tail keywords in the context of SEO.\n- They are longer, more specific keyword phrases that users typically use, representing less common and less competitive search queries.",
            "They are longer, more specific keyword phrases that users typically use, representing less common and less competitive search queries.",
            6,
            10.0
        ),
        QuestionMetadata(
            200,
            -1f,
            0,
            200,
            "What metrics or KPIs (Key Performance Indicators) are most commonly used to measure the success of a social media marketing campaign?\n- Likes, shares, comments, and clicks.",
            "Likes, shares, comments, and clicks.",
            6,
            10.0
        ),
        QuestionMetadata(
            201,
            -1f,
            0,
            201,
            "How does local SEO differ from traditional SEO?\n- Local SEO is designed primarily to increase a company's exposure in local search results, making it more relevant for local clients.",
            "Local SEO is designed primarily to increase a company's exposure in local search results, making it more relevant for local clients.",
            6,
            10.0
        ),
        QuestionMetadata(
            202,
            -1f,
            0,
            202,
            "What is the buyer's journey in the context of content marketing?\n- A framework that represents the stages a potential customer goes through when considering a purchase.",
            "A framework that represents the stages a potential customer goes through when considering a purchase.",
            6,
            10.0
        ),
    )
}

val topic8Questions by lazy {
    val questionsSet20 = listOf(
        QuestionMetadata(
            203,
            -1f,
            0,
            203,
            "Which of the following content is protected by copyright?\n- Original and fixed work.",
            "Original and fixed work.",
            7,
            10.0
        ),
        QuestionMetadata(
            204,
            -1f,
            0,
            204,
            "What is the role of a copyright notice?\n- Without it, the work does not receive protection under the copyright law.",
            "Without it, the work does not receive protection under the copyright law.",
            7,
            10.0
        ),
        QuestionMetadata(
            205,
            -1f,
            0,
            205,
            "What represents an original work?\n- A work created by a human author, by themselves, without copying, and that has a minimal degree of creativity.",
            "A work created by a human author, by themselves, without copying, and that has a minimal degree of creativity.",
            7,
            10.0
        ),
        QuestionMetadata(
            206,
            -1f,
            0,
            206,
            "Under which circumstances a content creator doesn’t need permission of the copyright owner to use copyrighted material?\n- For 'fair use'.",
            "For 'fair use'.",
            7,
            10.0
        ),
        QuestionMetadata(
            207,
            -1f,
            0,
            207,
            "Which symbol is used to mark a work as copyrighted?\n- ©",
            "©",
            7,
            10.0
        ),


        QuestionMetadata(
            208,
            -1f,
            0,
            208,
            "Which of the following is considered fixed content?\n- Written down or recorded work.",
            "Written down or recorded work.",
            7,
            10.0
        ),
        QuestionMetadata(
            209,
            -1f,
            0,
            209,
            "Who owns the copyright of a work?\n- The content creator.",
            "The content creator.",
            7,
            10.0
        ),
        QuestionMetadata(
            210,
            -1f,
            0,
            210,
            "What is the public domain?\n- All works to which no exclusive intellectual property rights apply.",
            "All works to which no exclusive intellectual property rights apply.",
            7,
            10.0
        ),
        QuestionMetadata(
            211,
            -1f,
            0,
            211,
            "By owning a musical recording (on CD for example), does it allow you to make copies and sell them?\n- No. Copying is allowed only if it can be justified by an exemption granted in the law.",
            "No. Copying is allowed only if it can be justified by an exemption granted in the law.",
            7,
            10.0
        ),
        QuestionMetadata(
            212,
            -1f,
            0,
            212,
            "Which of the following are considered 'works made for hire'?\n- Works created by an employee, within the scope of employment.",
            "Works created by an employee, within the scope of employment.",
            7,
            10.0
        ),


        QuestionMetadata(
            213,
            -1f,
            0,
            213,
            "Which one of the following is the best explanation of copyright law?\n- A law that protects an original invention",
            "A law that protects an original invention",
            7,
            10.0
        ),
        QuestionMetadata(
            214,
            -1f,
            0,
            214,
            "Why is it a good idea to get the author's permission to use a creative work, even if you think it may be fair use?\n- Fair use law is open to interpretation.",
            "Fair use law is open to interpretation.",
            7,
            10.0
        ),
        QuestionMetadata(
            215,
            -1f,
            0,
            215,
            "If a work is in the Public Domain, it means:\n- The Term of copyright in the work has run out.",
            "The Term of copyright in the work has run out.",
            7,
            10.0
        ),
        QuestionMetadata(
            216,
            -1f,
            0,
            216,
            "Creative commons allows copyright holders to:\n- Make their work available for public use, under specific conditions.",
            "Make their work available for public use, under specific conditions.",
            7,
            10.0
        ),
        QuestionMetadata(
            217,
            -1f,
            0,
            217,
            "Which of the following is/are defense(s) to copyright Infringement?\n- Fair Use",
            "Fair Use",
            7,
            10.0
        ),


        QuestionMetadata(
            218,
            -1f,
            0,
            218,
            "What is Fair Use?\n- Pictures and essays",
            "Pictures and essays",
            7,
            10.0
        ),
        QuestionMetadata(
            219,
            -1f,
            0,
            219,
            "For a work to be protectible under copyright, it must:\n- Be original.",
            "Be original.",
            7,
            10.0
        ),
        QuestionMetadata(
            220,
            -1f,
            0,
            220,
            "What is copyright infringement?\n- Anyone who uses someone's work without permission",
            "Anyone who uses someone's work without permission",
            7,
            10.0
        ),
        QuestionMetadata(
            221,
            -1f,
            0,
            221,
            "The term of copyright for a work posted on a web site:\n- Lasts for the life of the author plus 70 years.",
            "Lasts for the life of the author plus 70 years.",
            7,
            10.0
        ),
        QuestionMetadata(
            222,
            -1f,
            0,
            222,
            "The poet Edgar Allen Poe write many well-known pieces of literary works, and he died in 1849. You can find legal and free copies of his writing on the internet. What category below applies to this situation?\n- Fair Use",
            "Fair Use",
            7,
            10.0
        ),


        QuestionMetadata(
            223,
            -1f,
            0,
            223,
            "Factors in determining whether a use of a copyrighted work is a Fair Use include:\n- All options are correct.",
            "All options are correct.",
            7,
            10.0
        ),
        QuestionMetadata(
            224,
            -1f,
            0,
            224,
            "Which of the following is NOT automatically covered by copyright?\n- Inventions",
            "Inventions",
            7,
            10.0
        ),
        QuestionMetadata(
            225,
            -1f,
            0,
            225,
            "Rights of copyright do not include:\n- The right to stop Fair Uses of one's work.",
            "The right to stop Fair Uses of one's work.",
            7,
            10.0
        ),
        QuestionMetadata(
            226,
            -1f,
            0,
            226,
            "If you create a piece of work at school, who usually owns the copyright?\n- You",
            "You",
            7,
            10.0
        ),
        QuestionMetadata(
            227,
            -1f,
            0,
            227,
            "If you paint a mural on a classroom wall as an assignment for your art class, who owns the copyright?\n- You do because you are the 'author' of the work.",
            "You do because you are the 'author' of the work.",
            7,
            10.0
        ),


        QuestionMetadata(
            228,
            -1f,
            0,
            228,
            "Which of the following items can be copyrighted?\n- Computer software",
            "Computer software",
            7,
            10.0
        ),
        QuestionMetadata(
            229,
            -1f,
            0,
            229,
            "Which of these statements is false?\n- Copyright protection requires the author to renew it periodically to maintain their rights.",
            "Copyright protection requires the author to renew it periodically to maintain their rights.",
            7,
            10.0
        ),
        QuestionMetadata(
            230,
            -1f,
            0,
            230,
            "A kindergarten child's finger painting cannot be copyrighted because:\n- It is not true; a kindergarten child's finger painting can be copyrighted.",
            "It is not true; a kindergarten child's finger painting can be copyrighted.",
            7,
            10.0
        ),
        QuestionMetadata(
            231,
            -1f,
            0,
            231,
            "Which of the following is illegal?\n- Copying a music CD to give to a friend",
            "Copying a music CD to give to a friend",
            7,
            10.0
        ),
        QuestionMetadata(
            232,
            -1f,
            0,
            232,
            "Which of the following statements are correct? One purpose of copyright is to:\n- Promote the progress of the arts, culture, and literature.",
            "Promote the progress of the arts, culture, and literature.",
            7,
            10.0
        ),
    )
}
val topic9Questions by lazy {
    listOf(
        QuestionMetadata(
            257,
            -1f,
            0,
            257,
            "What is an important role of licenses?\n- Provides clear guidelines, rules, and stipulations that cover the use of digital content.",
            "Provides clear guidelines, rules, and stipulations that cover the use of digital content.",
            8,
            10.0
        ),
        QuestionMetadata(
            258,
            -1f,
            0,
            258,
            "From a cost point of view, which of the below affirmations is correct?\n- Depending on the vendor's objectives, the license can be free, or a fee might be needed to use the licensed digital content or product.",
            "Depending on the vendor's objectives, the license can be free, or a fee might be needed to use the licensed digital content or product.",
            8,
            10.0
        ),
        QuestionMetadata(
            259,
            -1f,
            0,
            259,
            "If you gain access to the source code of a software product, are you free to use it any way you want? Justify the answer.\n- No, because the license agreement usually contains stipulations on this scenario.",
            "No, because the license agreement usually contains stipulations on this scenario.",
            8,
            10.0
        ),
        QuestionMetadata(
            260,
            -1f,
            0,
            260,
            "Which statement regarding open-source licenses is true?\n- They allow the use, modification, distribution, reuse of digital content.",
            "They allow the use, modification, distribution, reuse of digital content.",
            8,
            10.0
        ),
        QuestionMetadata(
            261,
            -1f,
            0,
            261,
            "What is the role of proprietary licenses?\n- Proprietary licenses grant the content creator, publisher, or other rightsholder or rightsholder partner a legal monopoly in accordance with modern copyright and intellectual property law.",
            "Proprietary licenses grant the content creator, publisher, or other rightsholder or rightsholder partner a legal monopoly in accordance with modern copyright and intellectual property law.",
            8,
            10.0
        ),


        QuestionMetadata(
            262,
            -1f,
            0,
            262,
            "Who sets the license agreement terms?\n- The vendor",
            "The vendor",
            8,
            10.0
        ),
        QuestionMetadata(
            263,
            -1f,
            0,
            263,
            "What is most likely to motivate a vendor to opt for a proprietary license for his content?\n- Profit",
            "Profit",
            8,
            10.0
        ),
        QuestionMetadata(
            264,
            -1f,
            0,
            264,
            "Which of the following is not a scope for licenses?\n- Marketing",
            "Marketing",
            8,
            10.0
        ),
        QuestionMetadata(
            265,
            -1f,
            0,
            265,
            "What is a license?\n- The official permission or permit to do, use, or own something, as well as the document of that permission or permit.",
            "The official permission or permit to do, use, or own something, as well as the document of that permission or permit.",
            8,
            10.0
        ),
        QuestionMetadata(
            266,
            -1f,
            0,
            266,
            "Why is it important for users to be aware of license agreements and respect them?\n- To avoid legal consequences, in addition to respecting intellectual property rights.",
            "To avoid legal consequences, in addition to respecting intellectual property rights.",
            8,
            10.0
        ),


        QuestionMetadata(
            267,
            -1f,
            0,
            267,
            "Which of the following statements regarding a licensing agreement is true legally?\n- It grants permission to use a resource.",
            "It grants permission to use a resource.",
            8,
            10.0
        ),
        QuestionMetadata(
            268,
            -1f,
            0,
            268,
            "What legal aspect is fundamental to understanding licensing agreements?\n- Contract law.",
            "Contract law.",
            8,
            10.0
        ),
        QuestionMetadata(
            269,
            -1f,
            0,
            269,
            "When utilizing a case study within a licensing course, what primary objective is typically achieved by exploring practical applications of licensing concepts?\n- To gain a deeper understanding of how licensing agreements are structured, negotiated, and executed in real-world scenarios, allowing students to apply theoretical knowledge to practical situations, is the primary objective of case studies.",
            "To gain a deeper understanding of how licensing agreements are structured, negotiated, and executed in real-world scenarios, allowing students to apply theoretical knowledge to practical situations, is the primary objective of case studies.",
            8,
            10.0
        ),
        QuestionMetadata(
            270,
            -1f,
            0,
            270,
            "In the context of negotiation simulations within a licensing course, what is the primary objective?\n- Focusing on intricate scenarios and negotiation techniques.",
            "Focusing on intricate scenarios and negotiation techniques.",
            8,
            10.0
        ),
        QuestionMetadata(
            271,
            -1f,
            0,
            271,
            "What kind of licensing arrangement may include a franchise, in terms of business?\n- Business license.",
            "Business license.",
            8,
            10.0
        ),


        QuestionMetadata(
            272,
            -1f,
            0,
            272,
            "When utilizing a case study within a licensing course, what primary objective is typically achieved by exploring practical applications of licensing concepts?\n- To develop a greater grasp of how licensing agreements are set up and carried out in actual settings, enabling the application of theory to real-world circumstances.",
            "To develop a greater grasp of how licensing agreements are set up and carried out in actual settings, enabling the application of theory to real-world circumstances.",
            8,
            10.0
        ),
        QuestionMetadata(
            273,
            -1f,
            0,
            273,
            "What is the primary goal of licensing agreements in business?\n- Granting authorization for the use of intellectual property.",
            "Granting authorization for the use of intellectual property.",
            8,
            10.0
        ),
        QuestionMetadata(
            274,
            -1f,
            0,
            274,
            "In the context of licensing, what does the term 'licensor' refer to?\n- The party granting the license.",
            "The party granting the license.",
            8,
            10.0
        ),
        QuestionMetadata(
            275,
            -1f,
            0,
            275,
            "Which of the following is not a typical objective of licensing intellectual property?\n- Protecting trade secrets.",
            "Protecting trade secrets.",
            8,
            10.0
        ),
        QuestionMetadata(
            276,
            -1f,
            0,
            276,
            "Which of the following best defines a licensing agreement?\n- A legally enforceable agreement that authorizes the use, creation, or sale of intellectual property on a specific set of terms and conditions.",
            "A legally enforceable agreement that authorizes the use, creation, or sale of intellectual property on a specific set of terms and conditions.",
            8,
            10.0
        ),


        QuestionMetadata(
            277,
            -1f,
            0,
            277,
            "What is the primary goal of licensing agreements in business?\n- To grant authorized permission to use, modify, or distribute assets.",
            "To grant authorized permission to use, modify, or distribute assets.",
            8,
            10.0
        ),
        QuestionMetadata(
            278,
            -1f,
            0,
            278,
            "In the context of licensing, what does the term 'licensee' refer to?\n- The person obtaining the license.",
            "The person obtaining the license.",
            8,
            10.0
        ),
        QuestionMetadata(
            279,
            -1f,
            0,
            279,
            "What is a key benefit of licensing intellectual property for creators and businesses?\n- Generating revenue through royalties.",
            "Generating revenue through royalties.",
            8,
            10.0
        ),
        QuestionMetadata(
            280,
            -1f,
            0,
            280,
            "Which activity is typically NOT covered in licensing agreements?\n- Crafting innovative marketing strategies to promote licensed products effectively.",
            "Crafting innovative marketing strategies to promote licensed products effectively.",
            8,
            10.0
        ),
        QuestionMetadata(
            281,
            -1f,
            0,
            281,
            "What is a common objective of licensing agreements in the entertainment industry?\n- Monetizing and capitalizing on the commercial potential of creative works, including films, music, and multimedia.",
            "Monetizing and capitalizing on the commercial potential of creative works, including films, music, and multimedia.",
            8,
            10.0
        ),


        QuestionMetadata(
            282,
            -1f,
            0,
            282,
            "Which term commonly refers to compensation paid by a licensee to a licensor for the use of licensed assets?\n- Royalties",
            "Royalties",
            8,
            10.0
        ),
        QuestionMetadata(
            283,
            -1f,
            0,
            283,
            "Which type of licensing often involves the use of open-source software, enabling collaborative development and modification by the global community?\n- Open-source software licensing, facilitating collaborative development, and distribution of software with shared source code",
            "Open-source software licensing, facilitating collaborative development, and distribution of software with shared source code",
            8,
            10.0
        ),
        QuestionMetadata(
            284,
            -1f,
            0,
            284,
            "Which of the following is not a scope for licences?\n- Marketing",
            "Marketing",
            8,
            10.0
        ),
        QuestionMetadata(
            285,
            -1f,
            0,
            285,
            "What does the term 'license' refer to?\n- A legal agreement granting permission to use, modify, or distribute assets.",
            "A legal agreement granting permission to use, modify, or distribute assets.",
            8,
            10.0
        ),
        QuestionMetadata(
            286,
            -1f,
            0,
            286,
            "Why is it crucial for individuals and organizations to carefully review and adhere to license agreements?\n- To ensure compliance with legal terms and avoid potential legal consequences.",
            "To ensure compliance with legal terms and avoid potential legal consequences.",
            8,
            10.0
        ),
    )

}


