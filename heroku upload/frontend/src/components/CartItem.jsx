import React, { useState } from 'react'
import { BiPlus, BiMinus } from "react-icons/bi"
import { motion } from 'framer-motion'
import { useStateValue } from '../context/StateProvider'
import { actionType } from '../context/reducer'
import { useEffect } from 'react'

const CartItem = ({item, flag, setFlag}) => {
    const [qty, setQty] = useState(item.qty)
    const [items, setItems] = useState([])
    const [{ cartItems }, dispatch] = useStateValue()

    const cartDispatch = () => {
        localStorage.setItem("cartItems", JSON.stringify(items));
        dispatch({
            type: actionType.SET_CART_ITEMS,
            cartItems: items,
        });
    }
    const updateQty = (action, id) => {
        if (action === 'add') {
            setQty(qty + 1)
            
            cartItems.map(item => {
                if (item.id === id) {
                    item.qty += 1
                    // setFlag(flag+1)
                }
            })
            cartDispatch()
        } 
        else {
            if (qty == 1) {
                setItems(cartItems.filter((item) => item.id !== id))
                // setFlag(flag+1)
                cartDispatch()
            } else {
                setQty(qty - 1)
                cartItems.map(item => {
                    if (item.id === id) {
                        item.qty -= 1
                        // setFlag(flag+1)
                    }
                })
                cartDispatch()
            }
        }
    }
    useEffect(() => {
        setItems(cartItems)
    }, [qty])

    return (
        <div className='w-full p-1 px-2 rounded-lg bg-cartItem flex items-center gap-2'>
            {/* {heroData && heroData.map(n=>(
                        <img src={n.imagesrc[0]} className='w-20 h-20 max-w-[60px] rounded-full object-contain' alt="" />
                    ))} */}
            <img src={item.imagesrc} className='w-20 h-20 max-w-[60px] rounded-full object-contain' alt="i1" />


            <div className='flex flex-col gap-2'>
                <p className='text-base text-gray-50'>{item?.name}</p>
                <p className='text-sm block text-gray-300 font-semibold'>${parseFloat(item?.price)*(qty)}</p>
            </div>
            <div className='group flex items-center gap-2 ml-auto cursor-pointer'>
                <motion.div whileTap={{ scale: 0.8 }} onClick={() => updateQty("remove", item?.id)}>
                    <BiMinus className='text-gray-50' />
                </motion.div>
                <p className='w-5 h-5 rounded-sm bg-cartBg text-gray-50 flex items-center justify-center'>{qty}</p>
                <motion.div whileTap={{ scale: 0.8 }} onClick={() => updateQty("add", item?.id)}>
                    <BiPlus className='text-gray-50' />
                </motion.div>
            </div>
        </div>
    )
}

export default CartItem