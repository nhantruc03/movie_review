import axios from 'axios';

export default axios.create({
    baseURL: 'http://localhost:8080',
    headers: {
        "Authorization": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuaGFudHJ1YzAzQGdtYWlsLmNvbSIsImlhdCI6MTY5MzM4Mjg5MSwiZXhwIjoxNjkzNDY5MjkxfQ.qRLEj3KmvMW8SY2AQt8ZSqQaWOcOyG357bbV1VN0WZI"
    }
});