type Callback = (data?: any) => void;

export class EventEmitter {
  private events: Record<string, Callback[]> = {};

  on(event: string, cb: Callback) {
    if (!this.events[event]) this.events[event] = [];
    this.events[event].push(cb);
  }

  emit(event: string, data?: any) {
    this.events[event]?.forEach(cb => cb(data));
  }
}