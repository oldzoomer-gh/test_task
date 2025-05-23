import type { Telegram } from "@twa-dev/types";

declare global {
  interface Window {
    Telegram: Telegram;
  }
}

export default function Home() {
//  return ();
}

async function sendData() {
  const initData = window.Telegram.WebApp.initData;

  return await fetch(process.env.API_URL + '/getUserData', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json;charset=utf-8'
    },
    body: JSON.stringify(initData)
  }).then(res => res.json());
}