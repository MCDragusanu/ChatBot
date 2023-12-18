package com.example.chatbot.main.domain.pre_defined_questions

import com.example.chatbot.main.data.question_metadata_database.entity.TopicMetadata
import com.example.chatbot.main.data.question_metadata_database.entity.QuestionRow


val predefinedTopics by lazy {
    listOf<TopicMetadata>(
        TopicMetadata(
            uid = 0,
            label = "Types and formats of digital contentTypes and formats of digital content",
            keyWords = "",
            imageUid = -1
        ),
        TopicMetadata(
            uid = 1,
            label = "Artificial Intelligence (AI) Generated Content",
            keyWords ="",
            imageUid = -1
        ),
        TopicMetadata(
            uid = 2,

        label = "Accessibility incorporation in digital content",
            keyWords = "",
        imageUid = -1
        ),
        TopicMetadata(
            uid = 3,
            label = "Virtual reality, augmented reality and mixed reality",
            keyWords = "",
            imageUid = -1
        ),
        TopicMetadata(
            uid = 4,
            label = "Digital content on personal, professional, and open platforms",
            keyWords = "",
            imageUid = -1
        ),
        TopicMetadata(
            uid = 5,
            label = "Data visualisation, Data manipulation, Data attribution",
            keyWords = "",
            imageUid = -1
        ),
        TopicMetadata(
            uid = 6,
            label = "SEO and digital marketing",
            keyWords = "",
            imageUid = -1
        ),
        TopicMetadata(
            uid = 7,
            label = "Protection techniques and mechanisms for copyrighting",
            keyWords = "",
            imageUid = -1
        ),
        TopicMetadata(uid = 7, label = "Licences", keyWords = "", imageUid = -1)
    )
}

val topic1Questions by lazy {
    listOf(
        // Set 1
        QuestionRow(
            uid = 0,
            questionUid = 0,
            questionContent = "Have I analyzed audience feedback and comments to identify areas for improvement and refinement in my content?",
            correctAnswer = "Yes, analyzing audience feedback and comments is essential to identify areas for improvement and refinement in content.",
            topicUid = 0,

            ),
        QuestionRow(
            uid = 1,
            questionUid = 1,
            questionContent = "Am I regularly updating my digital content with the latest data, statistics, and industry trends to keep it relevant and valuable?",
            correctAnswer = "Yes, regularly updating digital content with the latest data, statistics, and industry trends is crucial to keep it relevant and valuable.",
            topicUid = 0,

            ),
        QuestionRow(
            uid = 2,
            questionUid = 2,
            questionContent = "Do I leverage multimedia elements, such as images, videos, and interactive elements, to enhance the visual appeal and engagement of my content?",
            correctAnswer = "Yes, leveraging multimedia elements, such as images, videos, and interactive elements, enhances the visual appeal and engagement of content.",
            topicUid = 0,

            ),
        QuestionRow(
            uid = 3,
            questionUid = 3,
            questionContent = "Have I integrated interactive elements, such as polls, quizzes, or calls-to-action, to encourage audience participation and create a more immersive experience?",
            correctAnswer = "Yes, integrating interactive elements, such as polls, quizzes, or calls-to-action, encourages audience participation and creates a more immersive experience.",
            topicUid = 0,

            ),
        QuestionRow(
            uid = 4,
            questionUid = 4,
            questionContent = "Am I optimizing my digital content for search engines by using relevant keywords, meta tags, and internal linking to improve its visibility and search rankings?",
            correctAnswer = "Yes, optimizing digital content for search engines by using relevant keywords, meta tags, and internal linking improves its visibility and search rankings.",
            topicUid = 0,

            ),
        QuestionRow(
            uid = 5,
            questionUid = 5,
            questionContent = "What is the purpose of refining digital content?",
            correctAnswer = "To ensure clarity, accuracy, and consistency, making it more effective and relevant to the target audience.",
            topicUid = 0,

            ),
        QuestionRow(
            uid = 6,
            questionUid = 6,
            questionContent = "How can multimedia elements enhance digital content?",
            correctAnswer = "By captivating the audience's attention, increasing engagement, and making the content more visually appealing.",
            topicUid = 0,

            ),
        QuestionRow(
            uid = 7,
            questionUid = 7,
            questionContent = "What are some examples of interactive elements that can be integrated into digital content?",
            correctAnswer = "Quizzes, polls, and calls-to-action.",
            topicUid = 0,

            ),
        QuestionRow(
            uid = 8,
            questionUid = 8,
            questionContent = "Why is updating digital content with the latest information and industry trends important?",
            correctAnswer = "To keep the content accurate, relevant, and valuable to the audience.",
            topicUid = 0,

            ),
        QuestionRow(
            uid = 9,
            questionUid = 9,
            questionContent = "How does integrating user feedback contribute to content improvement?",
            correctAnswer = "By allowing content creators to address the audience's needs and preferences, making the content more effective.",
            topicUid = 0,

            ),

        // Set 2
        QuestionRow(
            uid = 10,
            questionUid = 0,
            questionContent = "What are the main types of text-based digital content?",
            correctAnswer = "Articles, blog posts, ebooks, and whitepapers.",
            topicUid = 0,

            ),
        QuestionRow(
            uid = 11,
            questionUid = 11,
            questionContent = "Name two formats commonly used for interactive digital content.",
            correctAnswer = "Quizzes and interactive infographics.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 12,
            questionUid = 12,
            questionContent = "How can businesses use social media content to engage with their audience effectively?",
            correctAnswer = "Creating and sharing valuable and relevant content that addresses their audience's needs and interests.",
            topicUid = 0,

            ),
        QuestionRow(
            uid = 13,
            questionUid = 13,
            questionContent = "Give an example of a digital content format that can be used to showcase product features and benefits.",
            correctAnswer = "An explainer video.",
            topicUid = 0,

            ),
        QuestionRow(
            uid = 14,
            questionUid = 14,
            questionContent = "Explain how virtual and augmented reality content can enhance user experiences.",
            correctAnswer = "Virtual and augmented reality content can enhance user experiences by providing immersive and interactive experiences that blend digital elements with the real world.",
            topicUid = 0,

            ),
        QuestionRow(
            uid = 15,
            questionUid = 15,
            questionContent = "What are some common examples of visual content used in digital marketing?",
            correctAnswer = "Infographics.",
            topicUid = 0,

            ),
        QuestionRow(
            uid = 16,
            questionUid = 16,
            questionContent = "Explain the difference between webinars and online courses as digital content formats.",
            correctAnswer = "Webinars are live or pre-recorded online events that focus on a specific topic or subject; they are more interactive and allow real-time engagement with the audience.",
            topicUid = 0,

            ),
        QuestionRow(
            uid = 17,
            questionUid = 17,
            questionContent = "How can user-generated content be leveraged to benefit a brand's digital marketing strategy?",
            correctAnswer = "User-generated content provides genuine feedback and testimonials from real customers, which can enhance the brand's credibility and build trust with potential customers.",
            topicUid = 0,

            ),
        QuestionRow(
            uid = 18,
            questionUid = 18,
            questionContent = "Name two formats commonly used for delivering audio content to the audience.",
            correctAnswer = "Podcasts and audiobooks.",
            topicUid = 0,

            ),
        QuestionRow(
            uid = 19,
            questionUid = 19,
            questionContent = "How can businesses use infographics to effectively communicate complex information?",
            correctAnswer = "Presenting data visually.",
            topicUid = 0,

            ),

        // Set 3
        QuestionRow(
            uid = 20,
            questionUid = 20,
            questionContent = "Have I explored a diverse range of sources, including articles, data, images, and videos, to gather different items of content and information?",
            correctAnswer = "Yes, exploring a diverse range of sources, including articles, data, images, and videos, is essential to gather different items of content and information.",
            topicUid = 0,

            ),
        QuestionRow(
            uid = 21,
            questionUid = 21,
            questionContent = "Did I identify common themes and connections among the various content items to create a cohesive narrative for the new content?",
            correctAnswer = "Yes, identifying common themes and connections among the various content items is crucial to create a cohesive narrative for the new content.",
            topicUid = 0,

            ),
        QuestionRow(
            uid = 22,
            questionUid = 22,
            questionContent = "Have I added my own unique insights and perspectives to bring a fresh and original angle to the content?",
            correctAnswer = "Yes, adding your own unique insights and perspectives is important to bring a fresh and original angle to the content.",
            topicUid = 0,

            ),
        QuestionRow(
            uid = 23,
            questionUid = 23,
            questionContent = "Did I integrate multimedia elements, such as images, videos, and infographics, to enhance the visual appeal of the new content?",
            correctAnswer = "Yes, integrating multimedia elements, such as images, videos, and infographics, enhances the visual appeal of the new content.",
            topicUid = 0,

            ),
        QuestionRow(
            uid = 24,
            questionUid = 24,
            questionContent = "Have I incorporated interactive elements, such as polls, quizzes, or calls-to-action, to create a more engaging and participative experience for the audience?",
            correctAnswer = "Yes, incorporating interactive elements, such as polls, quizzes, or calls-to-action, creates a more engaging and participative experience for the audience.",
            topicUid = 0,

            ),
        QuestionRow(
            uid = 25,
            questionUid = 25,
            questionContent = "Why is it important to explore a diverse range of sources, such as articles, data, images, and videos, when gathering content for creating new and original digital content?",
            correctAnswer = "It provides a variety of perspectives and insights for a more comprehensive and unique content creation.",
            topicUid = 0,

            ),
        QuestionRow(
            uid = 26,
            questionUid = 26,
            questionContent = "How does identifying common themes and connections among the various content items contribute to the creation of a cohesive narrative?",
            correctAnswer = "By helping to create a logical flow and structure, ensuring the content is well-connected and coherent.",
            topicUid = 0,

            ),
        QuestionRow(
            uid = 27,
            questionUid = 27,
            questionContent = "Why is adding your own unique insights and perspectives essential when creating new digital content?",
            correctAnswer = "Adding your own unique insights and perspectives is essential when creating new digital content because it brings a fresh and original angle to the content, making it unique and engaging.",
            topicUid = 0,

            ),
        QuestionRow(
            uid = 28,
            questionUid = 28,
            questionContent = "How do multimedia elements, such as images, videos, and infographics, enhance the visual appeal of digital content?",
            correctAnswer = "Multimedia elements enhance the visual appeal of digital content by captivating the audience's attention and making the content more visually appealing and engaging.",
            topicUid = 0,

            ),
        QuestionRow(
            uid = 29,
            questionUid = 29,
            "What is the purpose of incorporating interactive elements, such as polls, quizzes, or calls-to-action, in digital content?",
            "Incorporating interactive elements in digital content is to create a more engaging and participative experience, encouraging audience interaction and feedback.",
            0,

            )
    )
}
val topic2Questions by lazy {
    listOf(
        // Set 1 (UIDs 30-59)
        QuestionRow(
            uid = 30,
            questionUid = 30,
            questionContent = "What is the purpose of refining digital content?",
            correctAnswer = "To ensure clarity, accuracy, and consistency, making it more effective and relevant to the target audience.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 31,
            questionUid = 31,
            questionContent = "How can multimedia elements enhance digital content?",
            correctAnswer = "By captivating the audience's attention, increasing engagement, and making the content more visually appealing.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 32,
            questionUid = 32,
            questionContent = "What are some examples of interactive elements that can be integrated into digital content?",
            correctAnswer = "Quizzes, polls, and calls-to-action.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 33,
            questionUid = 33,
            questionContent = "Why is updating digital content with the latest information and industry trends important?",
            correctAnswer = "To keep the content accurate, relevant, and valuable to the audience.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 34,
            questionUid = 34,
            questionContent = "How does integrating user feedback contribute to content improvement?",
            correctAnswer = "By allowing content creators to address the audience's needs and preferences, making the content more effective.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 35,
            questionUid = 35,
            questionContent = "What are the main types of text-based digital content?",
            correctAnswer = "Articles, blog posts, ebooks, and whitepapers.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 36,
            questionUid = 36,
            questionContent = "Name two formats commonly used for interactive digital content.",
            correctAnswer = "Quizzes and interactive infographics.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 37,
            questionUid = 37,
            questionContent = "How can businesses use social media content to engage with their audience effectively?",
            correctAnswer = "Creating and sharing valuable and relevant content that addresses their audience's needs and interests.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 38,
            questionUid = 38,
            questionContent = "Give an example of a digital content format that can be used to showcase product features and benefits.",
            correctAnswer = "An explainer video.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 39,
            questionUid = 39,
            questionContent = "Explain how virtual and augmented reality content can enhance user experiences.",
            correctAnswer = "Virtual and augmented reality content can enhance user experiences by providing immersive and interactive experiences that blend digital elements with the real world.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 40,
            questionUid = 40,
            questionContent = "What are some common examples of visual content used in digital marketing?",
            correctAnswer = "Infographics.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 41,
            questionUid = 41,
            questionContent = "Explain the difference between webinars and online courses as digital content formats.",
            correctAnswer = "Webinars are live or pre-recorded online events that focus on a specific topic or subject; they are more interactive and allow real-time engagement with the audience.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 42,
            questionUid = 42,
            questionContent = "How can user-generated content be leveraged to benefit a brand's digital marketing strategy?",
            correctAnswer = "User-generated content provides genuine feedback and testimonials from real customers, which can enhance the brand's credibility and build trust with potential customers.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 43,
            questionUid = 43,
            questionContent = "Name two formats commonly used for delivering audio content to the audience.",
            correctAnswer = "Podcasts and audiobooks.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 44,
            questionUid = 44,
            questionContent = "How can businesses use infographics to effectively communicate complex information?",
            correctAnswer = "Presenting data visually.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 45,
            questionUid = 45,
            questionContent = "Have I explored a diverse range of sources, including articles, data, images, and videos, to gather different items of content and information?",
            correctAnswer = "Yes, exploring a diverse range of sources, including articles, data, images, and videos, is essential to gather different items of content and information.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 46,
            questionUid = 46,
            questionContent = "Did I identify common themes and connections among the various content items to create a cohesive narrative for the new content?",
            correctAnswer = "Yes, identifying common themes and connections among the various content items is crucial to create a cohesive narrative for the new content.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 47,
            questionUid = 47,
            questionContent = "Have I added my own unique insights and perspectives to bring a fresh and original angle to the content?",
            correctAnswer = "Yes, adding your own unique insights and perspectives is important to bring a fresh and original angle to the content.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 48,
            questionUid = 48,
            questionContent = "Did I integrate multimedia elements, such as images, videos, and infographics, to enhance the visual appeal of the new content?",
            correctAnswer = "Yes, integrating multimedia elements, such as images, videos, and infographics, enhances the visual appeal of the new content.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 49,
            questionUid = 49,
            questionContent = "Have I incorporated interactive elements, such as polls, quizzes, or calls-to-action, to create a more engaging and participative experience for the audience?",
            correctAnswer = "Yes, incorporating interactive elements, such as polls, quizzes, or calls-to-action, creates a more engaging and participative experience for the audience.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 50,
            questionUid = 50,
            questionContent = "Why is it important to explore a diverse range of sources, such as articles, data, images, and videos, when gathering content for creating new and original digital content?",
            correctAnswer = "It provides a variety of perspectives and insights for a more comprehensive and unique content creation.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 51,
            questionUid = 51,
            questionContent = "How does identifying common themes and connections among the various content items contribute to the creation of a cohesive narrative?",
            correctAnswer = "By helping to create a logical flow and structure, ensuring the content is well-connected and coherent.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 52,
            questionUid = 52,
            questionContent = "Why is adding your own unique insights and perspectives essential when creating new digital content?",
            correctAnswer = "Adding your own unique insights and perspectives is essential when creating new digital content because it brings a fresh and original angle to the content, making it unique and engaging.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 53,
            questionUid = 53,
            questionContent = "How do multimedia elements, such as images, videos, and infographics, enhance the visual appeal of digital content?",
            correctAnswer = "Multimedia elements enhance the visual appeal of digital content by captivating the audience's attention and making the content more visually appealing and engaging.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 54,
            questionUid = 54,
            questionContent = "How does integrating user feedback contribute to content improvement?",
            correctAnswer = "By allowing content creators to address the audience's needs and preferences, making the content more effective.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 55,
            questionUid = 55,
            questionContent = "Why is updating digital content with the latest information and industry trends important?",
            correctAnswer = "To keep the content accurate, relevant, and valuable to the audience.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 56,
            questionUid = 56,
            questionContent = "How does identifying common themes and connections among the various content items contribute to the creation of a cohesive narrative?",
            correctAnswer = "By helping to create a logical flow and structure, ensuring the content is well-connected and coherent.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 57,
            questionUid = 57,
            questionContent = "Why is adding your own unique insights and perspectives essential when creating new digital content?",
            correctAnswer = "Adding your own unique insights and perspectives is essential when creating new digital content because it brings a fresh and original angle to the content, making it unique and engaging.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 58,
            questionUid = 58,
            questionContent = "How do multimedia elements, such as images, videos, and infographics, enhance the visual appeal of digital content?",
            correctAnswer = "Multimedia elements enhance the visual appeal of digital content by captivating the audience's attention and making the content more visually appealing and engaging.",
            topicUid = 1,

            ),
        QuestionRow(
            uid = 59,
            questionUid = 59,
            questionContent = "What is the purpose of refining digital content?",
            correctAnswer = "To ensure clarity, accuracy, and consistency, making it more effective and relevant to the target audience.",
            topicUid = 1,

            ),
    )
}

val topic3Questions by lazy {

    listOf(
        QuestionRow(
            60,

            60,
            "What is the primary purpose of following WCAG guidelines in web development?",
            "To make web content more accessible to people with disabilities",
            2,

            ),
        QuestionRow(
            61,


            61,
            "Which HTML element is crucial for adding alternative text to images for screen readers?",
            "<img> with the alt attribute",
            2,

            ),
        QuestionRow(
            62,


            62,
            "When implementing keyboard navigation, which aspect is most important?",
            "Ensuring that all content can be navigated using keyboard controls",
            2,

            ),
        QuestionRow(
            63,


            63,
            "Which of the following would not be a part of your accessibility checklist?",
            "Page view counts",
            2,

            ),
        QuestionRow(
            64,


            64,
            "Why is captioning multimedia content important?",
            "It provides a textual alternative for those who cannot hear the audio",
            2,

            ),
        QuestionRow(
            65,


            65,
            "In the context of accessible web development, what does 'screen reader compatibility' mean?",
            "The website can be navigated and understood using screen reader software",
            2,

            ),
        QuestionRow(
            66,


            66,
            "Which CSS property is important for ensuring sufficient contrast between text and background?",
            "color contrast",
            2,

            ),
        QuestionRow(
            67,


            67,
            "What kind of testing is crucial after developing an accessible website?",
            "Accessibility testing",
            2,

            ),
        QuestionRow(
            68,


            68,
            "What does the term 'user experience' encompass in accessible web design?",
            "The experience of users with disabilities as well as those without",
            2,

            ),
        QuestionRow(
            69,


            69,
            "Which automated tool can be used for accessibility testing?",
            "WAVE (Web Accessibility Evaluation Tool)",
            2,

            ),


        QuestionRow(
            70,


            70,
            "When modifying form inputs to be more accessible, what is a crucial feature to add?",
            "Error handling and descriptive labels",
            2,

            ),
        QuestionRow(
            71,


            71,
            "What kind of testing is important after implementing new accessibility features?",
            "Usability testing with participants who have disabilities",
            2,

            ),
        QuestionRow(
            72,


            72,
            "Why are alternative texts for images important?",
            "They describe the image for users who cannot see it",
            2,

            ),
        QuestionRow(
            73,


            73,
            "Which web development tool can be used to check for accessibility compliance?",
            "Automated accessibility checking tools",
            2,

            ),
        QuestionRow(
            74,


            5,
            "In terms of accessibility, what does proper tab indexing influence?",
            "The order in which elements are focused during keyboard navigation",
            2,

            ),
        QuestionRow(
            75,


            75,
            "What is the benefit of adding captions to video content?",
            "Captions provide a textual representation of the audio for hearing-impaired users",
            2,

            ),
        QuestionRow(
            76,


            76,
            "How can interactivity be maintained for users with limited mobility when designing web content?",
            "By ensuring all interactive elements are operable with keyboard commands",
            2,

            ),
        QuestionRow(
            77,


            77,
            "Why is color contrast important in web design for accessibility?",
            "It ensures text is legible to users with visual impairments.",
            2,

            ),
        QuestionRow(
            78,


            78,
            "What is an outcome of successful accessibility enhancements in web development?",
            "The website becomes usable by a wider range of users, including those with disabilities.",
            2,

            ),
        QuestionRow(
            79,


            79,
            "Which approach is least effective in creating accessible web content?",
            "Adding accessibility features as an afterthought",
            2,

            ),


        QuestionRow(
            80,


            80,
            "What is the primary goal of empathy mapping in accessible content creation?",
            "To understand the experiences and needs of users with disabilities",
            2,

            ),
        QuestionRow(
            81,


            81,
            "Universal design principles in digital content creation aim to?",
            "Create content that is accessible and usable by all people",
            2,

            ),
        QuestionRow(
            82,


            82,
            "When setting benchmarks for inclusion, what are participants primarily focusing on?",
            "The level of accessibility and usability for diverse users",
            2,

            ),
        QuestionRow(
            83,


            83,
            "Which technology can be used to generate descriptive alt text for visual content?",
            "Artificial Intelligence",
            2,

            ),
        QuestionRow(
            84,


            84,
            "Interactive voice response systems are implemented in web browsing to assist users who?",
            "Have difficulty using traditional navigation methods",
            2,

            ),
        QuestionRow(
            85,


            85,
            "Semantic HTML is used in accessible web design to?",
            "Create a clear structure that assists screen readers and other assistive technologies",
            2,

            ),
        QuestionRow(
            86,


            86,
            "Responsive design practices ensure that digital content is?",
            "Consistently accessible across a range of devices and screen sizes",
            2,

            ),
        QuestionRow(
            87,


            87,
            "What aspect of digital content is evaluated using automated accessibility tools?",
            "Compliance with accessibility standards",
            2,

            ),
        QuestionRow(
            88,


            88,
            "How does AI contribute to web accessibility?",
            "By generating alternative text for images",
            2,

            ),
        QuestionRow(
            89,


            89,
            "In accessible content strategy, layout considerations should?",
            "Prioritize ease of navigation and logical structure for all users",
            2,

            )
    )
}

val topic4Questions by lazy {
    listOf(
        QuestionRow(
            90,


            90,
            "Which of the following is NOT a common technology used in VR, AR, and MR systems?",
            "Microphone",
            3,

            ),
        QuestionRow(
            91,


            91,
            "What is the primary purpose of a Motion Tracking System?",
            "To track the user's head and body movements",
            3,

            ),
        QuestionRow(
            92,


            92,
            "Which of the following statements is TRUE about VR systems?",
            "VR systems use HMDs to completely block out the real world and display a virtual environment.",
            3,

            ),
        QuestionRow(
            93,


            93,
            "Which of the following statements is TRUE about AR systems?",
            "AR systems use HMDs or other wearable devices to display digital information onto the real world",
            3,

            ),
        QuestionRow(
            94,


            94,
            "Which of the following statements is TRUE about MR systems?",
            "MR systems combine elements of both VR and AR to create experiences that blend the real and virtual worlds.",
            3,

            ),
        QuestionRow(
            95,


            95,
            "Which of the following is NOT a common application for VR systems?",
            "Video conferencing",
            3,

            ),
        QuestionRow(
            96,


            96,
            "Which of the following is NOT a common application for MR systems?",
            "Customer service",
            3,

            ),
        QuestionRow(
            97,


            97,
            "Which of the following is the MOST important factor to consider when choosing a VR headset?",
            "Field of view",
            3,

            ),
        QuestionRow(
            98,


            98,
            "What is the MOST promising potential application for VR, AR, and MR systems?",
            "Healthcare",
            3,

            ),
        QuestionRow(
            99,


            99,
            "Which of the following statements is the MOST accurate prediction about the future of VR, AR, and MR systems?",
            "VR, AR, and MR systems will be used for a wide range of applications, including gaming, education, healthcare, and manufacturing.",
            3,

            ),


        QuestionRow(
            100,


            100,
            "Which of the following is NOT an example of modifying a VR, AR, or MR experience?",
            "Integrating two or more experiences",
            3,

            ),
        QuestionRow(
            101,


            101,
            "What is the most important thing to consider when modifying a VR, AR, or MR experience?",
            "The user experience",
            3,

            ),
        QuestionRow(
            102,


            102,
            "Which of the following is NOT an example of refining a VR, AR, or MR experience?",
            "Adding new content",
            3,

            ),
        QuestionRow(
            103,


            103,
            "What is the most important thing to consider when refining a VR, AR, or MR experience?",
            "The user feedback",
            3,

            ),
        QuestionRow(
            104,


            104,
            "Which of the following is NOT an example of improving a VR, AR, or MR experience?",
            "Removing content",
            3,

            ),
        QuestionRow(
            105,


            105,
            "What is the most important thing to consider when improving a VR, AR, or MR experience?",
            "The user needs",
            3,

            ),
        QuestionRow(
            106,


            106,
            "Which of the following is NOT an example of integrating VR, AR, and MR experiences?",
            "Replacing VR, AR, and MR experiences with traditional experiences",
            3,

            ),
        QuestionRow(
            107,


            107,
            "Which of the following is NOT a challenge of integrating VR, AR, and MR?",
            "Market acceptance challenges",
            3,

            ),
        QuestionRow(
            108,


            108,
            "Which of the following is NOT an opportunity of integrating VR, AR, and MR?",
            "Reduced costs",
            3,

            ),


        QuestionRow(
            109,


            109,
            "Which tool is commonly used for developing Virtual Reality experiences?",
            "Unity",
            3,

            ),
        QuestionRow(
            110,


            110,
            "Which of the following best describes Mixed Reality (MR)?",
            "Combines elements of both VR and AR",
            3,

            ),
        QuestionRow(
            111,


            111,
            "What is the primary component for user immersion in VR?",
            "Graphics",
            3,

            ),
        QuestionRow(
            112,


            112,
            "What ethical aspect is crucial in VR/AR/MR development?",
            "User Safety",
            3,

            ),
        QuestionRow(
            113,


            113,
            "Which language is commonly used for VR programming?",
            "C#",
            3,

            ),
        QuestionRow(
            114,


            114,
            "What is the main goal of integrating elements across VR, AR, and MR platforms?",
            "Seamless User Experience",
            3,

            ),
        QuestionRow(
            115,


            115,
            "What does VR provide that AR doesn't?",
            "Fully immersive environment",
            3,

            ),
        QuestionRow(
            116,


            116,
            "What is the key challenge in MR integration?",
            "Complexity",
            3,

            ),
        QuestionRow(
            117,


            117,
            "In AR, what is used to place virtual objects in the real world?",
            "Anchor points",
            3,

            ),
        QuestionRow(
            118,


            118,
            "What is one of the ethical considerations when creating a VR experience?",
            "Data Privacy",
            3,

            ),
    )
}
val topic5Questions by lazy {
    listOf(
        QuestionRow(
            119,


            119,
            "Which of the following is NOT a type of digital content?",
            "Print material",
            4,

            ),
        QuestionRow(
            120,


            120,
            "Which platform is NOT typically used for sharing digital content with a global audience?",
            "Email",
            4,

            ),
        QuestionRow(
            121,


            121,
            "Which of the following is NOT a tip for creating high-quality digital content?",
            "Plagiarize other people's work",
            4,

            ),
        QuestionRow(
            122,


            122,
            "Which of the following is NOT an ethical consideration when creating and sharing digital content?",
            "Sharing personal information without permission",
            4,

            ),
        QuestionRow(
            123,


            123,
            "Which of the following is NOT a step in the process of creating and sharing high-quality digital content?",
            "Ignore peer review",
            4,

            ),


        QuestionRow(
            124,


            124,
            "What is an open-access platform?",
            "A platform with unrestricted access to content",
            4,

            ),
        QuestionRow(
            125,


            125,
            "Which is not a social media platform?",
            "Google Search",
            4,

            ),
        QuestionRow(
            126,


            126,
            "What is clickbait?",
            "A misleading headline to get clicks",
            4,

            ),
        QuestionRow(
            127,


            127,
            "Which of the following criteria is NOT important for assessing the quality of digital content?",
            "Content is visually appealing",
            4,

            ),
        QuestionRow(
            128,


            128,
            "Which of the following is NOT an ethical consideration when promoting your digital content?",
            "Pay for fake social media followers",
            4,

            ),


        QuestionRow(
            129,


            129,
            "What is the primary objective of content modification?",
            "To improve user experience",
            4,

            ),
        QuestionRow(
            130,


            130,
            "Which tool is commonly used for text editing?",
            "Microsoft Word",
            4,

            ),
        QuestionRow(
            131,


            131,
            "What does content integration involve?",
            "Combining different types of content",
            4,

            ),
        QuestionRow(
            132,


            132,
            "Which of the following is NOT a best practice for modifying and improving existing digital content?",
            "Use a lot of jargon and technical terms",
            4,

            ),
        QuestionRow(
            133,


            133,
            "Which of the following is a good way to optimize your content for search engines?",
            "Use relevant keywords throughout your content.",
            4,

            ),


        QuestionRow(
            134,


            134,
            "What is the main goal of using data analytics in content refinement?",
            "To make data-driven decisions",
            4,

            ),
        QuestionRow(
            135,


            135,
            "Why is user feedback crucial for content improvement?",
            "It provides valuable insights",
            4,

            ),
        QuestionRow(
            136,


            136,
            "What is the primary consideration in content improvement?",
            "User Experience",
            4,

            ),
        QuestionRow(
            137,


            137,
            "Which of the following is NOT a cross-platform integration technique?",
            "Use proprietary content formats",
            4,

            ),
        QuestionRow(
            138,


            138,
            "Which of the following is NOT a key performance indicator (KPI) for digital content?",
            "Brand awareness",
            4,

            ),


        QuestionRow(
            139,


            139,
            "What is an essential aspect of creating original content for personal platforms?",
            "Personal Branding",
            4,

            ),
        QuestionRow(
            140,


            140,
            "Which tool is commonly used for professional content creation?",
            "Adobe Creative Suite",
            4,

            ),
        QuestionRow(
            141,


            141,
            "Which of the following is an ethical consideration in content creation?",
            "Copyright Laws",
            4,

            ),
        QuestionRow(
            142,


            142,
            "What does a content strategy typically include?",
            "Target Audience",
            4,

            ),
        QuestionRow(
            143,


            143,
            "Which element should not be part of your portfolio?",
            "Plagiarized Content",
            4,

            ),
        QuestionRow(
            144,


            144,
            "Which of the following is NOT a good practice for cross-platform optimization?",
            "Use proprietary content formats.",
            4,

            ),
        QuestionRow(
            145,


            145,
            "Which of the following is NOT a good way to optimize your images for web viewing?",
            "Use high-resolution images.",
            4,

            ),
        QuestionRow(
            146,


            146,
            "Which of the following is NOT a responsive design principle?",
            "Use fixed widths and heights.",
            4,

            ),
        QuestionRow(
            147,


            147,
            "Which of the following is NOT a way to be inspired by other creators?",
            "Copy other creators' work",
            4,

            ),
        QuestionRow(
            148,


            148,
            "Which of the following is NOT a good way to experiment with different techniques and styles?",
            "Be afraid to fail.",
            4,

            ),
    )
}
val topic6Questions by lazy {
    listOf(
        QuestionRow(
            149,


            149,
            "Which of the following tools is primarily used for data visualization?",
            "Excel",
            5,

            ),
        QuestionRow(
            150,


            150,
            "Which of the following best describes data attribution?",
            "Crediting the source of data",
            5,

            ),
        QuestionRow(
            151,


            151,
            "What does data manipulation primarily involve?",
            "Changing Data Structure",
            5,

            ),
        QuestionRow(
            152,


            152,
            "What is intellectual property in the context of data attribution?",
            "Acknowledging data source",
            5,

            ),
        QuestionRow(
            153,


            153,
            "What does ethical data sourcing primarily aim to ensure?",
            "Data Integrity",
            5,

            ),
        QuestionRow(
            154,


            154,
            "Which of the following should you avoid in data visualization?",
            "3D effects",
            5,

            ),
        QuestionRow(
            155,


            155,
            "In terms of data manipulation, what does 'joining' mean?",
            "Combining two datasets",
            5,

            ),
        QuestionRow(
            156,


            156,
            "What is the main objective of data attribution?",
            "To ensure data integrity and ethical use",
            5,

            ),
        QuestionRow(
            157,


            157,
            "Which of the following is NOT a data manipulation task?",
            "Visualizing data",
            5,

            ),
        QuestionRow(
            158,


            158,
            "Which of the following is NOT an important ethical consideration for data collection, storage, use, and sharing?",
            "Data ownership",
            5,

            ),


        QuestionRow(
            159,


            159,
            "Which of the following is NOT a best practice for modifying, refining, and improving data manipulation?",
            "Data",
            5,

            ),
        QuestionRow(
            160,


            160,
            "Which of the following is NOT a common data manipulation technique?",
            "Visualizing",
            5,

            ),
        QuestionRow(
            161,


            161,
            "Which of the following data manipulation techniques is used to identify and correct errors and inconsistencies in data?",
            "Cleaning",
            5,

            ),
        QuestionRow(
            162,


            162,
            "Which of the following data manipulation techniques is used to combine data from multiple sources into a single dataset?",
            "Merging",
            5,

            ),
        QuestionRow(
            163,


            163,
            "Which of the following criteria is NOT important for evaluating the effectiveness of data manipulation techniques?",
            "Transparency",
            5,

            ),
        QuestionRow(
            164,


            164,
            "What is the first step in a data manipulation challenge?",
            "Selecting a dataset",
            5,

            ),
        QuestionRow(
            165,


            165,
            "Which task involves organizing data into categories?",
            "Grouping",
            5,

            ),
        QuestionRow(
            166,


            166,
            "What function is used to change the orientation of the dataset?",
            "Transposing",
            5,

            ),
        QuestionRow(
            167,


            167,
            "Which tool can be used for data manipulation tasks?",
            "Excel",
            5,

            ),
        QuestionRow(
            168,


            168,
            "What is the purpose of filtering data?",
            "To display only the rows that meet certain criteria",
            5,

            ),


        QuestionRow(
            169,


            169,
            "What is the primary objective of the Data Visualization Challenge?",
            "To create an interactive visualization of a complex dataset in Excel",
            5,

            ),
        QuestionRow(
            170,


            170,
            "Which tool is recommended for the Data Visualization Challenge?",
            "Microsoft Excel",
            5,

            ),
        QuestionRow(
            171,


            171,
            "What is a key task in the Data Manipulation Challenge?",
            "Data cleaning",
            5,

            ),
        QuestionRow(
            172,


            172,
            "Data wrangling, often performed in the Data Manipulation Challenge, primarily involves:",
            "Transforming and mapping data from one format to another",
            5,

            ),
        QuestionRow(
            173,


            173,
            "In the Data Attribution Challenge, what are students required to do?",
            "Identify the data sources used in a visualization or publication",
            5,

            ),
        QuestionRow(
            174,


            174,
            "For effective data visualization, what is a crucial aspect to consider?",
            "Making the visualization interactive and engaging",
            5,

            ),
        QuestionRow(
            175,


            175,
            "In the context of Excel, what feature is often used for interactive data visualizations?",
            "Pivot Tables",
            5,

            ),
        QuestionRow(
            176,


            176,
            "When identifying data sources in the Data Attribution Challenge, students must look for",
            "The original source of the data used in the visualization",
            5,

            ),
        QuestionRow(
            177,


            177,
            "What is a common outcome of data cleaning in the Data Manipulation Challenge?",
            "A more accurate and reliable dataset",
            5,

            ),
        QuestionRow(
            178,


            178,
            "During the Data Attribution Challenge, what indicates a credible data source?",
            "A source that is well-documented and transparent",
            5,

            ),
    )

}

val topic7Questions by lazy {
    listOf(
        QuestionRow(
            179,


            179,
            "What is the role of Search Engine Optimization (SEO)?",
            "Improving organic traffic to a webpage/website.",
            6,

            ),
        QuestionRow(
            180,


            180,
            "From the perspective of digital marketing, is SEO sufficient?",
            "No, paid advertising, social media marketing, email marketing, and content marketing complements SEO in bringing customers to a website.",
            6,

            ),
        QuestionRow(
            181,


            181,
            "Which of the following represent Search Engine Optimization tools?",
            "Ahrefs, Moz, and Screaming Frog.",
            6,

            ),
        QuestionRow(
            182,


            182,
            "How can you identify issues such as broken links, duplicate content, and site speed problems?",
            "By conducting a comprehensive audit of a website's SEO performance.",
            6,

            ),


        QuestionRow(
            183,


            183,
            "What is the primary goal of on-page SEO optimization?",
            "Optimizing elements within the web page to enhance its chances of ranking higher in a SERP.",
            6,

            ),
        QuestionRow(
            184,


            184,
            "What is the primary goal of social media marketing for businesses?",
            "Develop and improve the brand, engage the audience, and promote the products.",
            6,

            ),
        QuestionRow(
            185,


            185,
            "How can you optimize a website for mobile SEO?",
            "Ensure that the site is mobile-friendly and provides a positive user experience for visitors accessing it from mobile devices.",
            6,

            ),
        QuestionRow(
            186,


            186,
            "How can A/B testing benefit email marketing campaigns?",
            "Provides valuable insights into which elements of the emails are most effective at engaging recipients.",
            6,

            ),
        QuestionRow(
            187,


            187,
            "Define keyword density in the context of SEO.",
            "Keyword density is the ratio of a given keyword to all the other words on a web page.",
            6,

            ),


        QuestionRow(
            188,


            188,
            "What is the purpose of a content marketing calendar, and how does it help in content planning?",
            "Provides a clear picture of what content will be developed, when it will be released, and who is accountable for its development.",
            6,

            ),
        QuestionRow(
            189,


            189,
            "How does site speed impact SEO, and what are some ways to improve it?",
            "Site speed impacts ranking and user experience, and it can be improved by On-Page SEO.",
            6,

            ),
        QuestionRow(
            190,


            190,
            "How can marketing automation improve the efficiency of email marketing campaigns?",
            "It streamlines various tasks like personalizing content and optimizing communication with subscribers.",
            6,

            ),
        QuestionRow(
            191,


            191,
            "What are backlinks?",
            "Backlinks are hyperlinks from one website to another.",
            6,

            ),
        QuestionRow(
            192,


            192,
            "Briefly explain the concept of customer segmentation.",
            "The process of categorizing a target audience into distinct groups based on shared characteristics or behaviors.",
            6,

            ),


        QuestionRow(
            193,


            193,
            "Explain the difference between a 'do-follow' and a 'no-follow' link.",
            "'do-follow' links are considered when crawling a webpage, while 'no-follow' links are not.",
            6,

            ),
        QuestionRow(
            194,


            194,
            "Define the term 'conversion rate' in the context of digital marketing.",
            "Refers to the percentage of website visitors that become customers.",
            6,

            ),
        QuestionRow(
            195,


            195,
            "What is an XML sitemap?",
            "An XML sitemap is a structured file that lists the URLs of a website's pages, along with additional metadata about each page.",
            6,

            ),
        QuestionRow(
            196,


            196,
            "Explain the concept of pay-per-click (PPC) advertising.",
            "PPC is a digital advertising model in which advertisers pay a fee each time one of their ads is clicked by a user.",
            6,

            ),
        QuestionRow(
            197,


            197,
            "What is the role of alt (alternative) text in SEO?",
            "The role of alt text is to provide a textual description of an image on a web page.",
            6,

            ),


        QuestionRow(
            198,


            198,
            "What are the key components of an effective landing page for online advertising.",
            "A compelling headline, engaging visuals, trust indicators, and key benefits and features of the offer or product.",
            6,

            ),
        QuestionRow(
            199,


            199,
            "Describe the concept of long-tail keywords in the context of SEO.",
            "They are longer, more specific keyword phrases that users typically use, representing less common and less competitive search queries.",
            6,

            ),
        QuestionRow(
            200,


            200,
            "What metrics or KPIs (Key Performance Indicators) are most commonly used to measure the success of a social media marketing campaign?",
            "Likes, shares, comments, and clicks.",
            6,

            ),
        QuestionRow(
            201,


            201,
            "How does local SEO differ from traditional SEO?",
            "Local SEO is designed primarily to increase a company's exposure in local search results, making it more relevant for local clients.",
            6,

            ),
        QuestionRow(
            202,


            202,
            "What is the buyer's journey in the context of content marketing?",
            "A framework that represents the stages a potential customer goes through when considering a purchase.",
            6,

            ),
    )
}

val topic8Questions by lazy {
    listOf(
        QuestionRow(
            203,


            203,
            "Which of the following content is protected by copyright?",
            "Original and fixed work.",
            7,

            ),
        QuestionRow(
            204,


            204,
            "What is the role of a copyright notice?",
            "Without it, the work does not receive protection under the copyright law.",
            7,

            ),
        QuestionRow(
            205,


            205,
            "What represents an original work?",
            "A work created by a human author, by themselves, without copying, and that has a minimal degree of creativity.",
            7,

            ),
        QuestionRow(
            206,


            206,
            "Under which circumstances a content creator doesn’t need permission of the copyright owner to use copyrighted material?",
            "For 'fair use'.",
            7,

            ),



        QuestionRow(
            208,


            208,
            "Which of the following is considered fixed content?",
            "Written down or recorded work.",
            7,

            ),
        QuestionRow(
            209,


            209,
            "Who owns the copyright of a work?",
            "The content creator.",
            7,

            ),
        QuestionRow(
            210,


            210,
            "What is the public domain?",
            "All works to which no exclusive intellectual property rights apply.",
            7,

            ),
        QuestionRow(
            211,


            211,
            "By owning a musical recording (on CD for example), does it allow you to make copies and sell them?",
            "No. Copying is allowed only if it can be justified by an exemption granted in the law.",
            7,

            ),
        QuestionRow(
            212,


            212,
            "Which of the following are considered 'works made for hire'?",
            "Works created by an employee, within the scope of employment.",
            7,

            ),


        QuestionRow(
            213,


            213,
            "Which one of the following is the best explanation of copyright law?",
            "A law that protects an original invention",
            7,

            ),
        QuestionRow(
            214,


            214,
            "Why is it a good idea to get the author's permission to use a creative work, even if you think it may be fair use?",
            "Fair use law is open to interpretation.",
            7,

            ),
        QuestionRow(
            215,


            215,
            "If a work is in the Public Domain, it means:",
            "The Term of copyright in the work has run out.",
            7,

            ),
        QuestionRow(
            216,


            216,
            "Creative commons allows copyright holders to:",
            "Make their work available for public use, under specific conditions.",
            7,

            ),
        QuestionRow(
            217,


            217,
            "Which of the following is/are defense(s) to copyright Infringement?",
            "Fair Use",
            7,

            ),


        QuestionRow(
            218,


            218,
            "What is Fair Use?",
            "Pictures and essays",
            7,

            ),
        QuestionRow(
            219,


            219,
            "For a work to be protectible under copyright, it must:",
            "Be original.",
            7,

            ),
        QuestionRow(
            220,


            220,
            "What is copyright infringement?",
            "Anyone who uses someone's work without permission",
            7,

            ),
        QuestionRow(
            221,


            221,
            "The term of copyright for a work posted on a web site:",
            "Lasts for the life of the author plus 70 years.",
            7,

            ),
        QuestionRow(
            222,


            222,
            "The poet Edgar Allen Poe write many well-known pieces of literary works, and he died in 1849. You can find legal and free copies of his writing on the internet. What category below applies to this situation?",
            "Fair Use",
            7,

            ),


        QuestionRow(
            223,


            223,
            "Factors in determining whether a use of a copyrighted work is a Fair Use include:",
            "All options are correct.",
            7,

            ),
        QuestionRow(
            224,


            224,
            "Which of the following is NOT automatically covered by copyright?",
            "Inventions",
            7,

            ),
        QuestionRow(
            225,


            225,
            "Rights of copyright do not include:",
            "The right to stop Fair Uses of one's work.",
            7,

            ),
        QuestionRow(
            226,


            226,
            "If you create a piece of work at school, who usually owns the copyright?",
            "Myself",
            7,

            ),
        QuestionRow(
            227,


            227,
            "If you paint a mural on a classroom wall as an assignment for your art class, who owns the copyright?",
            "Myself because you are the 'author' of the work.",
            7,

            ),


        QuestionRow(
            228,


            228,
            "Which of the following items can be copyrighted?",
            "Computer software",
            7,

            ),
        QuestionRow(
            229,


            229,
            "Which of these statements is false?",
            "Copyright protection requires the author to renew it periodically to maintain their rights.",
            7,

            ),
        QuestionRow(
            230,


            230,
            "A kindergarten child's finger painting cannot be copyrighted because:",
            "It is not true; a kindergarten child's finger painting can be copyrighted.",
            7,

            ),
        QuestionRow(
            231,


            231,
            "Which of the following is illegal?",
            "Copying a music CD to give to a friend",
            7,

            ),
        QuestionRow(
            232,


            232,
            "Which of the following statements are correct? One purpose of copyright is to:",
            "Promote the progress of the arts, culture, and literature.",
            7,

            ),
    )
}
val topic9Questions by lazy {
    listOf(
        QuestionRow(
            257,


            257,
            "What is an important role of licenses?",
            "Provides clear guidelines, rules, and stipulations that cover the use of digital content.",
            8,

            ),
        QuestionRow(
            258,


            258,
            "From a cost point of view, which of the below affirmations is correct?.",
            "Depending on the vendor's objectives, the license can be free, or a fee might be needed to use the licensed digital content or product.",
            8,

            ),
        QuestionRow(
            259,


            259,
            "If you gain access to the source code of a software product, are you free to use it any way you want? Justify the answer.",
            "No, because the license agreement usually contains stipulations on this scenario.",
            8,

            ),
        QuestionRow(
            260,


            260,
            "Which statement regarding open-source licenses is true?",
            "They allow the use, modification, distribution, reuse of digital content.",
            8,

            ),
        QuestionRow(
            261,


            261,
            "What is the role of proprietary licenses?",
            "Proprietary licenses grant the content creator, publisher, or other rightsholder or rightsholder partner a legal monopoly in accordance with modern copyright and intellectual property law.",
            8,

            ),


        QuestionRow(
            262,


            262,
            "Who sets the license agreement terms?",
            "The vendor",
            8,

            ),
        QuestionRow(
            263,


            263,
            "What is most likely to motivate a vendor to opt for a proprietary license for his content?",
            "Profit",
            8,

            ),
        QuestionRow(
            264,


            264,
            "Which of the following is not a scope for licenses?",
            "Marketing",
            8,

            ),
        QuestionRow(
            265,


            265,
            "What is a license?",
            "The official permission or permit to do, use, or own something, as well as the document of that permission or permit.",
            8,

            ),
        QuestionRow(
            266,


            266,
            "Why is it important for users to be aware of license agreements and respect them?",
            "To avoid legal consequences, in addition to respecting intellectual property rights.",
            8,

            ),


        QuestionRow(
            267,


            267,
            "Which of the following statements regarding a licensing agreement is true legally?",
            "It grants permission to use a resource.",
            8,

            ),
        QuestionRow(
            268,


            268,
            "What legal aspect is fundamental to understanding licensing agreements?",
            "Contract law.",
            8,

            ),
        QuestionRow(
            269,


            269,
            "When utilizing a case study within a licensing course, what primary objective is typically achieved by exploring practical applications of licensing concepts?",
            "To gain a deeper understanding of how licensing agreements are structured, negotiated, and executed in real-world scenarios, allowing students to apply theoretical knowledge to practical situations, is the primary objective of case studies.",
            8,

            ),
        QuestionRow(
            270,


            270,
            "In the context of negotiation simulations within a licensing course, what is the primary objective?",
            "Focusing on intricate scenarios and negotiation techniques.",
            8,

            ),
        QuestionRow(
            271,


            271,
            "What kind of licensing arrangement may include a franchise, in terms of business?",
            "Business license.",
            8,

            ),


        QuestionRow(
            272,


            272,
            "When utilizing a case study within a licensing course, what primary objective is typically achieved by exploring practical applications of licensing concepts?",
            "To develop a greater grasp of how licensing agreements are set up and carried out in actual settings, enabling the application of theory to real-world circumstances.",
            8,

            ),
        QuestionRow(
            273,


            273,
            "What is the primary goal of licensing agreements in business?",
            "Granting authorization for the use of intellectual property.",
            8,

            ),
        QuestionRow(
            274,


            274,
            "In the context of licensing, what does the term 'licensor' refer to?",
            "The party granting the license.",
            8,

            ),
        QuestionRow(
            275,


            275,
            "Which of the following is not a typical objective of licensing intellectual property?",
            "Protecting trade secrets.",
            8,

            ),
        QuestionRow(
            276,


            276,
            "Which of the following best defines a licensing agreement?",
            "A legally enforceable agreement that authorizes the use, creation, or sale of intellectual property on a specific set of terms and conditions.",
            8,

            ),


        QuestionRow(
            277,


            277,
            "What is the primary goal of licensing agreements in business?",
            "To grant authorized permission to use, modify, or distribute assets.",
            8,

            ),
        QuestionRow(
            278,


            278,
            "In the context of licensing, what does the term 'licensee' refer to?",
            "The person obtaining the license.",
            8,

            ),
        QuestionRow(
            279,


            279,
            "What is a key benefit of licensing intellectual property for creators and businesses?",
            "Generating revenue through royalties.",
            8,

            ),
        QuestionRow(
            280,


            280,
            "Which activity is typically NOT covered in licensing agreements?",
            "Crafting innovative marketing strategies to promote licensed products effectively.",
            8,

            ),
        QuestionRow(
            281,


            281,
            "What is a common objective of licensing agreements in the entertainment industry?",
            "Monetizing and capitalizing on the commercial potential of creative works, including films, music, and multimedia.",
            8,

            ),


        QuestionRow(
            282,


            282,
            "Which term commonly refers to compensation paid by a licensee to a licensor for the use of licensed assets?",
            "Royalties",
            8,

            ),
        QuestionRow(
            283,


            283,
            "Which type of licensing often involves the use of open-source software, enabling collaborative development and modification by the global community?",
            "Open-source software licensing, facilitating collaborative development, and distribution of software with shared source code",
            8,

            ),
        QuestionRow(
            284,


            284,
            "Which of the following is not a scope for licences?",
            "Marketing",
            8,

            ),
        QuestionRow(
            285,


            285,
            "What does the term 'license' refer to?",
            "A legal agreement granting permission to use, modify, or distribute assets.",
            8,

            ),
        QuestionRow(
            286,


            286,
            "Why is it crucial for individuals and organizations to carefully review and adhere to license agreements?",
            "To ensure compliance with legal terms and avoid potential legal consequences.",
            8,

            ),
    )

}


