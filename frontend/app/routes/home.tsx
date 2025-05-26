import type { Telegram } from "@twa-dev/types";

declare global {
  interface Window {
    Telegram: Telegram;
  }
}

export default function Home() {
  auth();
  const userInfoData = userInfo();

  return (
    <main className="flex min-h-screen flex-col items-center justify-between p-24">
      <div className="z-10 max-w-5xl w-full items-center justify-between font-mono text-sm lg:flex">
        <h1>Hello, {userInfoData.username}</h1>
        <h1>Your real name is {userInfoData.first_name} {userInfoData.last_name}</h1>
        <h1>Your id is {userInfoData.id}</h1>
        <h1>Your language code is {userInfoData.language_code}</h1>
        <h1>Your user is premium is {userInfoData.is_premium}</h1>
      </div>
    </main>
  );
}

async function auth() {
  const initData = window.Telegram.WebApp.initData;

  await fetch(process.env.API_URL + '/auth', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json;charset=utf-8'
    },
    body: JSON.stringify(initData),
    credentials: 'include'
  }).then(res => res.json());
}

async function userInfo() {
  return await fetch(process.env.API_URL + '/userInfo', {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json;charset=utf-8'
    },
    credentials: 'include'
  }).then(res => res.json());
}