import { Route, Routes } from 'react-router-dom';
import React from 'react'
import {AnimatePresence} from 'framer-motion'
import { Admin,  Header, MainContainer } from './components';
import Contact from "./components/Contact"
import Signup from './components/Signup';
import Login from './components/Login';
import AllRestaurant from './components/AllRestaurant';
import Restaurant from './components/Restaurant';


const App = () => {
  return (
    <AnimatePresence>
    <div className="w-screen h-auto flex flex-col bg-primary">
        <Header/>

        <main className='mt-7 md:mt-10 px-4 md:px-16 py-2 w-full'>
          <Routes>
            <Route exact path='/*' element={<MainContainer />}/>
            <Route exact path='/Admin' element={<Admin />}/>
            <Route exact path="/Contact" element={<Contact/>}/>
            <Route exact path="/Login" element={<Login/>}/>
            <Route exact path="/AllRestaurant" element={<AllRestaurant />}/>
            <Route exact path="/Restaurant" element={<Restaurant />}/>

          </Routes>
        </main>
    </div>
    </AnimatePresence>
  )
}

export default App