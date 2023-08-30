import './App.css';
import api from './api/AxiosConfig';
import { useState, useEffect } from 'react';
import Layout from './components/Layout';
import { Routes, Route } from 'react-router-dom';
import Home from './components/home/Home';
import Header from './components/header/Header';
import Trailer from './components/trailer/Trailer';
import Reviews from './components/review/Review';
import NotFound from './components/notFound/NotFound';

function App() {

  const [movies, setMovies] = useState();
  const [movie, setMovie] = useState();
  const [reviews, setReviews] = useState([]);

  const getMovies = async () => {

    await api.get("/api/v1/movie/all").
      then(res => {
        console.log('response', res);
        setMovies(res.data.body.data)
      })
      .catch(err => console.log(err))

  }

  const getMovieData = async (movieId) => {
     
    try 
    {
        const allreviews = await api.get(`/api/v1/review?movieId=${movieId}`);

        setReviews(allreviews.data.body.data);
        console.log(allreviews.data.body.data);

        const singleMovie = await api.get(`/api/v1/movie/${movieId}`);

        setMovie(singleMovie.data.body.data);
        console.log(singleMovie.data.body.data);

    } 
    catch (error) 
    {
      console.error(error);
    }

  }

  useEffect(() => {
    getMovies();
  }, [])

  return (
    <div className="App">
      <Header/>
      <Routes>
        <Route path='/' element={<Layout />}>
          <Route path="/" element={<Home movies={movies} />} ></Route>
          <Route path="/Trailer/:TrailerId" element={<Trailer />} ></Route>
          <Route path="/Reviews/:movieId" element ={<Reviews getMovieData = {getMovieData} movie={movie} reviews ={reviews} setReviews = {setReviews} />}></Route>
          <Route path="*" element = {<NotFound/>}></Route>
        </Route>
      </Routes>
    </div>
  );
}

export default App;
