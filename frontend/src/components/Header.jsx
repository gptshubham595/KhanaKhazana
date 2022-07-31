import React, {/*{ useState }*/ } from 'react'
import Logo from "./img/logo.png"
import { BsCart4 } from "react-icons/bs"
import Avatar from "./img/avatar.png"
import { motion } from 'framer-motion'
import { Link } from 'react-router-dom'
import { useStateValue } from '../context/StateProvider'
import { actionType } from '../context/reducer'
// import { useStateValue } from '../context/StateProvider'


const Header = () => {
  // const[{user},dispatch]=useStateValue();
  // const [isMenu, setisMenu] = useState(false)
  const[{cartShow, cartItems}, dispatch]=useStateValue()

  const showCart=()=>{
    dispatch({
      type: actionType.SET_CART_SHOW,
      cartShow:!cartShow
    })
  }

  return (
    <div className=" z-50 w-screen bg-slate-300 p-3 px-4 md:p-6 md:px=16 bg-primary">
      <div className="hidden md:flex w-full h-full item-center justify-between ">
        <Link to={"/"} className='flex items-center gap-2'>
          <img src={Logo} className='w-10 object-cover' alt="logo" />
          <p className='text-headingColor text-xl font-bold'>City</p>
        </Link>
        <div className='flex item-center gap-8'>
          <motion.ul intial={{ opacity: 0, y: 200 }}
            animate={{ opacity: 1, x: 0 }}
            exit={{ opacity: 0, y: 200 }}
            className='flex items-center gap-8'>
            <Link to={"/restaurant"} className="text-bse text-textColor hover:text-headingColor cursor-pointer duration-100 transition-all ease-in-out cursor-pointer">
              Restaurant
            </Link>
            <Link to={"/contact"} className="text-bse text-textColor hover:text-headingColor cursor-pointer duration-100 transition-all ease-in-out cursor-pointer">
              Contact us</Link>
            <Link to={"/login"} className="text-bse text-textColor hover:bg-gray-200 rounded py-2 px-4 bg-white hover:text-headingColor cursor-pointer duration-100 transition-all ease-in-out cursor-pointer">
              Sign In</Link>
          </motion.ul>
        
          <div className='relative flex items-center justify-center' onClick={showCart}>
            <BsCart4 className='text-textColor text-2xl ml-8 cursor-pointer' />
            {cartItems && cartItems.length>0 &&(
              <div className='absolute -top-0 -right-0 w-4 h-4 rounded-full bg-cartNumBg flex item-center justify-center'>
              <p className=' -top-1 text-xs text-white font-semi-bold '>{cartItems.length}</p>
            </div>
            )}
          </div>
          <motion.img whileTap={{ scale: 0.8 }}
            src={Avatar} className="w-10 min-w-[40px] h-10 min-h-[40px] drop-shadow-2xl cursor-pointer rounded-full" alt="userprofile" />

          {
            // isMenu && (
            <div className='w-40 bg-primary shadow-xl rounded-lg flex  flex-col absolute top-16 right-12 px-4 py-2 '>
              <p className='px-4 py-2 flex items-center gap-3 cursor-pointer hover:bg-slate-200 transition-all duration-100 ease-in-out text-textColor text-base'>My profile</p>
              <p className='px-4 py-2 flex items-center gap-3 cursor-pointer hover:bg-red-500 transition-all duration-100 ease-in-out text-textColor text-base'>Logout</p>
            </div>
            // )
          }
        </div>
      </div>

      <div className="flex items-center justify-between md:hidden w-full h-full ">
        
        <div className='relative flex items-center justify-center' onClick={showCart}>
            <BsCart4 className='text-textColor text-2xl ml-8 cursor-pointer' />
            {cartItems && cartItems.length>0 &&(
              <div className='absolute -top-0 -right-0 w-4 h-4 rounded-full bg-cartNumBg flex item-center justify-center'>
              <p className=' -top-1 text-xs text-white font-semi-bold '>{cartItems.length}</p>
            </div>
            )}
          </div>
          <Link to={"/"} className='flex items-center gap-2'>
          <img src={Logo} className='w-10 object-cover' alt="logo" />
          <p className='text-headingColor text-xl font-bold'>City</p>
        </Link>
        <motion.img whileTap={{ scale: 0.8 }}
          src={Avatar} className="w-10 min-w-[40px] h-10 min-h-[40px] drop-shadow-2xl cursor-pointer rounded-full" alt="userprofile" />

        {
          // isMenu && (
          <div className='w-40 bg-primary shadow-xl rounded-lg flex  flex-col absolute top-16 right-12 px-4 py-2 '>
            <p className='px-4 py-2 flex items-center gap-3 cursor-pointer hover:bg-slate-200 transition-all duration-100 ease-in-out text-textColor text-base'>My profile</p>
            <ul className='flex flex-col '>
            <Link to={"/restaurant"} className="text-bse px-4 py-2 text-textColor hover:text-headingColor hover:bg-slate-200 cursor-pointer duration-100 transition-all ease-in-out cursor-pointer">
              Restaurant
            </Link>
            <li className="text-bse text-textColor px-4 py-2 hover:text-headingColor hover:bg-slate-200 cursor-pointer duration-100 transition-all ease-in-out cursor-pointer">
              Contact us</li>
            <Link to={"/login"} className="text-bse px-4 py-2 text-textColor hover:bg-slate-200 rounded py-2 px-4 bg-primary hover:text-headingColor cursor-pointer duration-100 transition-all ease-in-out cursor-pointer">
              Sign In</Link>
          </ul>
            <p className='px-4 py-2 rounded-md flex items-center gap-3 cursor-pointer hover:bg-red-500 transition-all duration-100 ease-in-out text-textColor text-base'>Logout</p>
          </div>
          // )
        }
      </div>
    </div>
    // </div >
  )
}

export default Header