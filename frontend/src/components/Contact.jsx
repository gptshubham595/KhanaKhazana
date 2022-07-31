import React from 'react'
import CallIcon from '@mui/icons-material/Call';
import MailIcon from '@mui/icons-material/Mail';
import LocationOnIcon from '@mui/icons-material/LocationOn';
import GroupIcon from '@mui/icons-material/Group';

const Contact = () => {
  return (
    <div>
    <div className='text-[2.5rem] h-100px'>Meet Us:</div>
    <div className='justify-center p-10'>
        <div className='flex items-center '><MailIcon/> &nbsp;&nbsp; :&nbsp;&nbsp;   helpdesk@olacabs.com</div>
        <div className='flex items-center '><CallIcon/> &nbsp;&nbsp; : &nbsp;&nbsp;1800-200-100</div>
        <div className='flex items-center '><LocationOnIcon/> &nbsp;&nbsp; :&nbsp;&nbsp;   2, Hosur Rd, Koramangala Industrial Layout, Koramangala, Bengaluru, Karnataka 560095</div>
    </div>
    <div className='text-[2rem]'>Developed By:</div>
    <div className='justify-center p-10'>
        <div className='flex items-center '><GroupIcon/>&nbsp;Group &nbsp;   9</div>
    </div>
    </div>
    
  )
}

export default Contact


  {/* <h1 className='text-[2.5rem]'>Meet us:</h1> */}
        {/* <div className='flex flex-col items-center justify-center'>
        <div className='items-left'>
            <p><CallIcon/></p>
            <p><MailIcon/></p>
            <p><LocationOnIcon/></p>
        </div>
        <div>
            <p>1800-200-300</p>
            <p>helpdesk@olacabs.com</p>
            <p>2, Hosur Rd, Koramangala Industrial Layout, Koramangala, Bengaluru, Karnataka 560095</p>
        </div> */}